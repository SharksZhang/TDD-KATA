package drone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 */
public class MessageSystem {

	public static final String ERROR_STR = "Error: ";

	public static final String CANNOT_FIND = "Cannot find ";

	public static final String SEPERATOR = " ";

	final ArrayList<Position> positions = new ArrayList<>();

	private String planeID;

	private int messagesLines;

	/**
	 *
	 * @param index
	 * @return
	 */
	public String getMessage(int index) {
		if (index >= messagesLines) {
			return CANNOT_FIND + index;
		}
		if (index < messagesLines && index >= positions.size()) {
			return ERROR_STR + index;
		}
		return planeID + SEPERATOR + index + SEPERATOR + positions.get(index);

	}


	public MessageSystem(String path) {
		ArrayList<String> messages = readFile(path);
		messagesLines = messages.size();
		if (messages.size() == 0) {
			return;
		}
		setPlaneID(messages.get(0));
		initPositions(messages);
	}

	private void initPositions(ArrayList<String> messages) {
		if (isFirstLineFormat(messages.get(0))) {
			positions.add(new Position(messages.get(0)));
		} else {
			return;
		}

		for (int i = 1; i < messages.size(); i++) {
			if (!isOthersLineFormat(messages.get(i))) {
				return;
			}

			if (!parsePlaneID(messages.get(i)).equals(planeID)) {
				return;
			}

			Position position = new Position(messages.get(i));
			if (!position.hasPrevious(positions.get(i - 1))) {
				return;
			}

			positions.add(position);
		}
	}

	private void setPlaneID(String s) {
		planeID = parsePlaneID(s);
	}

	private String parsePlaneID(String s) {
		return s.split(SEPERATOR)[0];
	}

	private ArrayList<String> readFile(String path) {
		File file = new File(path);
		ArrayList<String> result = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			result = new ArrayList<>(bufferedReader.lines().collect(Collectors.toList()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public boolean isFirstLineFormat(String s) {
		return !checkFormat(s, 4);
	}

	public boolean isOthersLineFormat(String s) {
		return !checkFormat(s, 7);
	}

	private boolean checkFormat(String s, int length) {
		String[] splits = s.split(" ");
		if (splits.length != length) {
			return true;
		}
		for (int i = 1; i < splits.length; i++) {
			try {
				Integer.parseInt(splits[i]);
			}
			catch (NumberFormatException e) {
				return true;
			}
		}
		return false;
	}
}
