//package argsfirsttime;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ArgsTest {
//
//	@Test
//	void shouldReturnFalseWhenGetBoolDoseNotGivenArg() throws Exception {
//		Args args = new Args("a", "");
//		assertFalse(args.getBoolean("a"));
//	}
//
//	@Test
//	void shouldReturnTrueWhenGetBoolGivenArgInSchema() throws Exception {
//		assertTrue(new Args("a", "-a").getBoolean("a"));
//	}
//
//	@Test
//	void shouldReturnTrueWhenGetBoolGivenTwoArgInSchema() throws Exception {
//		Args args = new Args("a,b", "-a -b");
//		assertTrue(args.getBoolean("a"));
//		assertTrue(args.getBoolean("b"));
//	}
//
//	@Test
//	void shouldThrowExceptionWhenArgNotInSchema() throws Exception {
//		assertThrows(Exception.class, () -> new Args("a", "-a -b"));
//	}
//
//	@Test
//	void shouldReturnResultWhenGetStringGivenTwoArgInSchema() throws Exception {
//		Args args = new Args("a*,b*", "-a bc");
//		assertEquals("bc", args.getString("a"));
//		assertEquals("", args.getString("b"));
//	}
//
//	@Test
//	void shouldThrowExceptionWhenGetTypeError() throws Exception {
//		Args args = new Args("a,b*", "-a -b c");
//		assertThrows(Exception.class, () -> args.getBoolean("b"));
//		assertThrows(Exception.class, () -> args.getString("a"));
//
//	}
//	@Test
//	void shouldThrowExceptionGivenErrorArguments() {
//		assertThrows(Exception.class, () -> new Args( "a,c", "a -c"));
//		assertThrows(Exception.class, () -> new Args("a", "-ab"));
//		assertThrows(Exception.class, () -> new Args("a", "--"));
//		assertThrows(Exception.class, () -> new Args("a", "-a b"));
//		assertThrows(Exception.class, () -> new Args("a,b*", "-b -a"));
//	}
//
//
//	@Test
//	void shouldReturnResultWhenGetIntegerGivenTwoArgInSchema() throws Exception {
//		Args args = new Args("a#,b#", "-a 111");
//		assertEquals(111, args.getInt("a"));
//		assertEquals(0, args.getInt("b"));
//	}
//
//	@Test
//	void shouldThrowExceptionWhenGetIntTypeError() throws Exception {
//		Args args = new Args("a,b#", "-a -b 1");
//		assertThrows(Exception.class, () -> args.getInt("a"));
//
//	}
//
//	@Test
//	void shouldReturnResultWhenGetDoubleGivenTwoArgInSchema() throws Exception {
//		Args args = new Args("a##,b##", "-a 111.0");
//		assertEquals(111.0, args.getDouble("a"));
//		assertEquals(0.0, args.getDouble("b"));
//	}
//
//	@Test
//	void shouldThrowExceptionWhenGetDoubleTypeError() throws Exception {
//		Args args = new Args("a,b#", "-a -b 1");
//		assertThrows(Exception.class, () -> args.getDouble("a"));
//
//	}
//
//}