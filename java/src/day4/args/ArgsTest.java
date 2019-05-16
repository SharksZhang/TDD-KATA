//package day4.args;
//
//import com.sun.org.apache.xpath.internal.Arg;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ArgsTest {
//
//    public static final String arg = "l";
//
//    @Test()
//    void shouldNotThrowExceptionGivenSchemaAndArgsIsNone() {
//        assertDoesNotThrow(() -> new Args("", ""));
//    }
//
//    @Test
//    void shouldThrowArgumentNotInSchemaGivenSchemaIsNoneArgumensNotNone() {
//        Exception e = assertThrows(ArgNotInSchemaException.class, () -> new Args("", "-f"));
//        assertTrue(e.getMessage().contains(ArgNotInSchemaException.SUFFIX));
//    }
//
//
//    @Disabled
//    void shouldThrowArgumentNotInSchemaGivenSomeArgNotInSchema() {
//        Exception e = assertThrows(ArgNotInSchemaException.class, () -> new Args("f,s*,", "-f -s Bob -n"));
//        assertTrue(e.getMessage().contains(ArgNotInSchemaException.SUFFIX));
//    }
//
//    @Test
//    void shouldTrueWhenGetBoolGivenSchemaAndArgsNotExist() throws Exception {
//        Args args = new Args("f", "");
//        assertFalse(args.getBool('f'));
//    }
//
//
//    @Test
//    void shouldTrueWhenGetBoolGivenSchemaAndArgsExist() throws Exception {
//        Args args = new Args("f", "-f");
//        assertTrue(args.getBool('f'));
//    }
//
//
//    @Test
//    void shouldThrowExceptionWhenGetBoolGivenArgNotInSchema() throws Exception {
//        Args args = new Args("f", "-f");
//        assertThrows(ArgNotInSchemaException.class, () -> args.getBool('h'));
//    }
//
//    @Test
//    void shouldReturnTrueWhenGetBoolGivenMultipleBoolArgInSchema() throws Exception {
//        Args args = new Args("f,h", "-f -h");
//        assertTrue(args.getBool('f'));
//        assertTrue(args.getBool('h'));
//    }
//
//
//
//    @Test
//    void shouldReturnNoneStrWhenGetStringGivenSchema() throws Exception {
//        Args args = new Args("s*", "");
//        assertEquals("", args.getString('s'));
//    }
//
//    @Test
//    void shouldReturnNoneStrWhenGetStringGivenSchemaMultipleArgs() throws Exception {
//        Args args = new Args("s*, a*", "-s c -a b");
//        assertEquals("c", args.getString('s'));
//        assertEquals("b", args.getString('a'));
//    }
//
//
//
//}