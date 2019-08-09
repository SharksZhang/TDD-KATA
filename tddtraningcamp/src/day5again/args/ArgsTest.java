package day5again.args;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {

    //-l -p 8080 -d /usr/logs
    //Example schema: (f,s*,n#,a##,p[*])

    @Test
    void should_throw_exception_when_get_null_flag() {
        Args args = new Args("", new String[]{""});
        assertFalse(args.getBool(""));
    }


    @Test
    void should_return_false_given_bool_args_is_null() {
        Args args = new Args("l", new String[]{""});
        assertFalse(args.getBool("l"));
    }

    @Test
    void should_return_true_give_bool_arg_exist_in_arguement() {
        Args arg = new Args("l", new String[]{"-l"});
        assertTrue(arg.getBool("l"));
    }
}
