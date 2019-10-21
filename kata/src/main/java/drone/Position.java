package drone;

public class Position {
	boolean status;

	String planeID;

	private int x;

	private int y;

	private int z;

	private int previousX;

	private int previousY;

	private int previousZ;

	public boolean hasPrevious(Position previous) {
		return previous.x == previousX && previous.y == previousY && previous.z ==previousZ;
	}

	public Position(String s) {
		String[] splits = s.split(" ");
		planeID = splits[0];

		previousX = Integer.parseInt(splits[1]);
		previousY = Integer.parseInt(splits[2]);
		previousZ = Integer.parseInt(splits[3]);
		int offSetX = 0;
		int offSetY = 0;
		int offSetZ = 0;
		if (splits.length == 7) {
			offSetX = Integer.parseInt(splits[4]);
			offSetY = Integer.parseInt(splits[5]);
			offSetZ = Integer.parseInt(splits[6]);
		}
		x = previousX + offSetX;
		y = previousY + offSetY;
		z = previousZ + offSetZ;

	}


	@Override
	public String toString() {
		return x + " " + y + " " + z;
	}
}
