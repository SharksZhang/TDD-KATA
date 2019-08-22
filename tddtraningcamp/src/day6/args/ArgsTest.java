package day6.args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgsTest {


	@Test
	void shouldReturnFalseWhenGetBoolDoseNotGivenArg() throws Exception {
		Args args = new Args("a", "");
		assertFalse(args.getBoolean("a"));
	}

	@Test
	void shouldReturnTrueWhenGetBoolGivenArgInSchema() throws Exception {
		assertTrue(new Args("a", "-a").getBoolean("a"));
	}

	@Test
	void shouldReturnTrueWhenGetBoolGivenTwoArgInSchema() throws Exception {
		Args args = new Args("a,b", "-a -b");
		assertTrue(args.getBoolean("a"));
		assertTrue(args.getBoolean("b"));
	}

	@Test
	void shouldThrowExceptionWhenArgNotInSchema() throws Exception {
		assertThrows(Exception.class, () -> new Args("a", "-a -b"));
	}

	@Test
	void shouldReturnResultWhenGetStringGivenTwoArgInSchema() throws Exception {
		Args args = new Args("a*,b*", "-a bc -b cd");
		assertEquals("bc", args.getString("a"));
		assertEquals("cd", args.getString("b"));
	}


	@Test
	void shouldThrowExceptionGivenErrorArguments() {
		assertThrows(Exception.class, () -> new Args( "a,c", "a -c"));
		assertThrows(Exception.class, () -> new Args("a", "-ab"));
		assertThrows(Exception.class, () -> new Args("a", "--"));
		assertThrows(Exception.class, () -> new Args("a", "-a b"));
		assertThrows(Exception.class, () -> new Args("a,b*", "-b -a"));
	}



}