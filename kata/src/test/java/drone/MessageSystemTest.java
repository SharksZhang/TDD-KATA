package drone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageSystemTest {
	private MessageSystem messageSystemRight;

	private MessageSystem messageSystemFirstLineWrong;


	@BeforeEach
	void setUp() {
		messageSystemRight = new MessageSystem("right.txt");
		messageSystemFirstLineWrong = new MessageSystem("firstlinewrong.txt");

	}

	/**
	 * plane1 1 1 1
	 * plane1 1 1 1 1 2 3
	 * plane1 2 3 4 1 1 1
	 * plane1 3 4 5
	 * plane1 1 1 1 1 2 3
	 */

	@Test
	void function_test() {
		assertEquals("plane1 0 1 1 1", messageSystemRight.getMessage(0));
		assertEquals("plane1 1 2 3 4", messageSystemRight.getMessage(1));
		assertEquals("plane1 2 3 4 5", messageSystemRight.getMessage(2));
		assertEquals("Error: 4", messageSystemRight.getMessage(4));
		assertEquals("Cannot find 100", messageSystemRight.getMessage(100));
	}

	@Test
	void should_return_plane_message_when_message_is_right() {

		assertEquals("plane1 0 1 1 1", messageSystemRight.getMessage(0));
		assertEquals("plane1 1 2 3 4", messageSystemRight.getMessage(1));
		assertEquals("plane1 2 3 4 5", messageSystemRight.getMessage(2));
	}

	@Test
	void should_return_can_not_find_when_index_out_of_range() {
		assertEquals("Cannot find 100", messageSystemRight.getMessage(100));
	}

	@Test
	void should_return_error_when_coordinate_is_not_the_same_as_previous() {
		MessageSystem system = new MessageSystem("X_Y_Z_error.txt");
		assertEquals("Error: 3", system.getMessage(3));
		assertEquals("Error: 2", system.getMessage(2));
	}
	/**
	 * plane1 1 1 1 1 1 1
	 * plane1 1 1 1 1 2 3
	 * plane1 2 3 4 1 1 1
	 * plane1 3 4 5
	 * plane1 1 1 1 1 2 3
	 */
	@Test
	void should_return_error_when_first_line_format_is_wrong_format() {
		assertEquals("Error: 0", messageSystemFirstLineWrong.getMessage(0));
		assertEquals("Error: 1", messageSystemFirstLineWrong.getMessage(1));
	}


	/**
	 * plane2 1 1 1
	 * plane1 1 1 1 1 2 3
	 * plane1 2 3 4 1 1 1
	 * plane1 3 4 5
	 * plane1 1 1 1 1 2 3
	 */
	@Test
	void should_return_error_when_plane_ID_is_different() {
		MessageSystem planeNameDifferent = new MessageSystem("planenamedifferent.txt");


		assertEquals("Error: 1", planeNameDifferent.getMessage(1));
	}

	/**
	 * plane1 1 1 1
	 * plane1 1 1 1
	 * plane1 2 3 4 1 1 1
	 * plane1 3 4 5
	 * plane1 1 1 1 1 2 3
	 */
	@Test
	void when_second_line_is_wrong_format() {
		 MessageSystem messageSystemSecondLineWrong = new MessageSystem("Secondlinewrong.txt");

		assertEquals("plane1 0 1 1 1", messageSystemSecondLineWrong.getMessage(0));
		assertEquals("Error: 1", messageSystemSecondLineWrong.getMessage(1));
		assertEquals("Error: 2", messageSystemSecondLineWrong.getMessage(2));
	}


	@Test
	void should_return_false_when_check_first_line_format_give_error_format() {
		assertFalse(messageSystemFirstLineWrong.isFirstLineFormat("plan1 1 1"));
		assertFalse(messageSystemFirstLineWrong.isFirstLineFormat("plan1 1a 1 1"));
		assertFalse(messageSystemFirstLineWrong.isFirstLineFormat("plan1 1a 1 1"));
	}

	@Test
	void should_return_true_when_check_first_line_format_give_right_format() {
		assertTrue(messageSystemFirstLineWrong.isFirstLineFormat("plan1 1 1 1"));
	}

	@Test
	void should_return_false_when_check_not_first_line_format_give_error_format() {
		assertFalse(messageSystemFirstLineWrong.isOthersLineFormat("plan1 1 1 1"));
		assertFalse(messageSystemFirstLineWrong.isOthersLineFormat("plan1 1a 1 1 1 1 1"));
	}

	@Test
	void should_return_true_when_check_not_first_line_format_give_right_format() {
		assertTrue(messageSystemFirstLineWrong.isOthersLineFormat("plan1 1 1 1 1 1 1"));
	}




}