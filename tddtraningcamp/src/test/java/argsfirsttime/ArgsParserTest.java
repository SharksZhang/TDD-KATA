//package argsfirsttime;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ArgsParserTest {
//
//	@Test
//	void shouldReturnFalseWhenGivenNone() throws Exception {
//		ArgsParser argsParser = new ArgsParser("");
//		assertFalse(argsParser.getBool("a"));
//	}
//
//
//	@Test
//	void shouldReturnValueWhenGivenValueInArguments() throws Exception {
//		ArgsParser argsParser = new ArgsParser("-a");
//		assertTrue(argsParser.getBool("a"));
//	}
//
//	@Test
//	void shouldReturnValueWhenGivenTwoValueInArguments() throws Exception {
//		ArgsParser argsParser = new ArgsParser("-a -b");
//		assertTrue(argsParser.getBool("a"));
//		assertTrue(argsParser.getBool("b"));
//	}
//
//
//	@Test
//	void shouldReturnWhenCheckArgString() throws Exception {
//		ArgsParser argsParser = new ArgsParser("-a aa -b aa");
//		assertEquals("aa", argsParser.getString("a"));
//	}
//
//}