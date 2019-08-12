package day5again.args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsParserTest {

	@Test
	void should_return_true_when_arguments_exist() throws Exception {
		ArgsParser argsParser = new ArgsParser("-l");
		assertTrue(argsParser.get("l"));
	}

	@Test
	void should_return_false_when_arguments_not_exist() throws Exception {
		ArgsParser argsParser = new ArgsParser("-l");
		assertFalse(argsParser.get("g"));
	}

	@Test
	void should_return_true_when_arguments_exist_given_two_flag() throws Exception {
		ArgsParser argsParser = new ArgsParser("-l -c");
		assertTrue(argsParser.get("l"));
		assertTrue(argsParser.get("c"));
	}

	@Test
	void should_throw_format_exception_when_argument_format_error() throws Exception {
		assertThrows(Exception.class, () -> new ArgsParser("-lc"));
	}

	@Test
	void should_throw_format_exception_when_argument_format_error2() throws Exception {
		assertThrows(Exception.class, () -> new ArgsParser("--"));
	}

	@Test
	void should_throw_format_exception_when_argument_format_error3() throws Exception {
		assertThrows(Exception.class, () -> new ArgsParser("aa"));
	}

	@Test
	void should_throw_format_exception_when_argument_format_error4() throws Exception {
		assertThrows(Exception.class, () -> new ArgsParser("-a -cc dd"));
	}

	@Test
	void should_return_true_give_multiple_arguments_get_exist_arg() throws Exception {
		ArgsParser argsParser = new ArgsParser("-a -b -c -d");
		assertTrue(argsParser.get("a"));
		assertFalse(argsParser.get("e"));
	}

	@Test
	void should_not_throw_format_exception_when_argument_is_none() throws Exception {
		assertDoesNotThrow(() -> new ArgsParser(""));
	}



}
