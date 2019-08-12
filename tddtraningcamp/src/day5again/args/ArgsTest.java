package day5again.args;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgsTest {

	//-l -p 8080 -d /usr/logs
	//Example schema: (f,s*,n#,a##,p[*])

	@Test
	void should_throw_exception_when_get_null_flag() throws Exception {
		Args args = new Args("", "");
		assertThrows(Exception.class, () -> args.getBool(""));
	}


	@Test
	void should_return_false_given_bool_args_is_null() throws Exception {
		Args args = new Args("l", "");
		assertFalse(args.getBool("l"));
	}

	@Test
	void should_return_true_give_bool_arg_exist_in_arguement() throws Exception {
		Args arg = new Args("l", "-l");
		assertTrue(arg.getBool("l"));
	}

	@Test
	void should_throw_exception_when_flag_not_in_schema() throws Exception {
		Args args = new Args("l", "-l");
		assertThrows(Exception.class, () -> args.getBool("a"));
	}

	@Test
	void should_throw_exception_when_flag_format_error() throws Exception {
		Args args = new Args("l", "-l");
		assertThrows(Exception.class, () -> args.getBool("-dsfa"));
	}


	@Test
	void should_throw_exception_when_get_string_given_flag_type_error() throws Exception {
		Args args = new Args("f,l*", "-l aaa");
		assertThrows(Exception.class, () -> args.getString("f"));
	}

	@Test
	void should_return_string_given_string() throws Exception {
		Args args = new Args("l*", "-l aaa");
		assertEquals("aaa", args.getString("l"));
	}

	@Test
	void should_return_none_string_does_not_given_string() throws Exception {
		Args args = new Args("l*", "");
		assertEquals("", args.getString("l"));
	}


	@Test
	void should_throw_exception_when_get_integer_given_flag_type_error() throws Exception {
		Args args = new Args("f,l*", "-l aaa");
			Exception e = assertThrows(Exception.class, () -> args.getString("f"));
		System.out.println(e.getMessage());
	}

	@Test
	void should_return_integer_given_integer() throws Exception {
		Args args = new Args("l#", "-l 111");
		assertEquals(111, args.getInteger("l"));
	}

	@Test
	void should_return_zero_does_not_given_integer() throws Exception {
		Args args = new Args("l#", "");
		assertEquals(0, args.getInteger("l"));
	}


	@Test
	void should_return_double_given_double() throws Exception {
		Args args = new Args("l##", "-l 2.0");
		assertEquals(2.0, args.getDouble("l"));
	}

	@Test
	void should_return_zero_does_not_given_double() throws Exception {
		Args args = new Args("l##", "");
		assertEquals(0.0, args.getDouble("l"));
	}

	@Test
	void should_return_rigth_value() throws Exception {
		Args args = new Args("l,p#,d*", "-l -p 8080 -d /usr/logs");
		assertTrue(args.getBool("l"));
		assertEquals(8080, args.getInteger("p"));
		assertEquals("/usr/logs", args.getString("d"));

	}



}
