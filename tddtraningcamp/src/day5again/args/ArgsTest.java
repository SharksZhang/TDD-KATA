package day5again.args;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgsTest {

    //-l -p 8080 -d /usr/logs
    //Example schema: (f,s*,n#,a##,p[*])

    @Test
    void should_throw_exception_when_get_null_flag() throws Exception {
        Args args = new Args("", "");
        assertThrows(Exception.class, () ->args.getBool(""));
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


}
