package day5.args;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {

    @Test
    void shouldNotThrowExceptionGivenSchemaAndArgsIsNil() {
        Exception e = assertThrows(SchemaWrongFormatException.class, () -> new Args("", ""));
        assertEquals("schema is null", e.getMessage());
    }

    @Test
    void ShouldThrowWrongFormatExceptionWhenNewArgsGivenSchemaWrongFormat() {
        assertThrows(SchemaWrongFormatException.class, () -> new Args("1111", ""));
    }

    @Test
    void shouldNotThrowExceptionWhenNewArgsGivenBooleanType() {
        assertDoesNotThrow (() -> new Args("f", ""));
    }

    @Test
    void shouldNotThrowExceptionWhenNewArgsGivenStringType() {
        assertDoesNotThrow (() -> new Args("f*", ""));

    }

    @Test
    void shouldNotThrowExceptionWhenNewArgsGivenIntegerType() {
        assertDoesNotThrow (() -> new Args("f#", ""));

    }

    @Test
    void shouldNotThrowExceptionWhenNewArgsGivenDoubleType() {
        assertDoesNotThrow (() -> new Args("f##", ""));

    }

    @Test
    void shouldNotThrowExceptionWhenNewArgsGivenStringArrayTypeType() {
        assertDoesNotThrow (() -> new Args("f[*]", ""));
    }

    @Test
    void shouldNotThrowExceptionWhenSchemaDuplicate() {
        Exception e = assertThrows (SchemaWrongFormatException.class, () -> new Args("f,f*,n#,a##,p[*]", ""));
        assertTrue(e.getMessage().contains("flag duplicate"));
    }

    @Test
    void shouldNotThrowExceptionWhenNewArgsGivenMultipleType() {
        assertDoesNotThrow (() -> new Args("f,s*,n#,a##,p[*]", ""));
    }

    @Test
    void shouldThrowArgumentNotExistInSchemaGivenArgsNotExistTypeBool() {
        assertThrows(ArgumentNotExistInSchemaException.class, () -> new Args("f,s*,n#,a##,p[*]", "-b"));
    }

    @Test
    void shouldThrowArgumentNotExistInSchemaGivenMultipleArgsNotExistTypeBool() {
        assertThrows(ArgumentNotExistInSchemaException.class, () -> new Args("f,s*,n#,a##,p[*]", "-f -d"));
    }

    @Test
    void shouldThrowArgumentNotExistInSchemaGivenMultipleArgsNotExistTypeString() {
        assertDoesNotThrow(()->new Args("f,s*,n#,a##,p[*]", "-s bb"));
    }

    @Test
    void shouldThrowArgumentFormatExceptionGivenTwoDigitsArgument() {
        assertThrows(ArgumentFormatException.class, () -> new Args("f,s*,n#,a##,p[*]", "-ss bb"));
    }

    @Test
    void shouldThrowBooleanArgumentDoesNotNeedValueExceptionGivenBoolValue() {
        assertThrows(BooleanArgumentDoesNotNeedValueException.class, () -> new Args("f,s*,n#,a##,p[*]", "-f bb"));
    }

    @Test
    void shouldThrowArgumentNeedValueExceptionGivenOthersValue() {
        assertThrows(ArgumentNeedValueException.class, () -> new Args("f,s*,n#,a##,p[*]", "-s "));
    }

    //需要使用正则表达式,先跳过

    @Disabled
    void shouldThrowArgsValueTypeExceptionGivenArgsValueWrong() {
        assertThrows(WrongArgsValueTypeException.class, () -> new Args("f,s*,n#,a##,p[*]", "-s @@@"));
    }

    @Test
    void shouldReturnTrueWhenGetBoolGivenTheArgBoolValue() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException, ArgumentTypeException {
        Args args = new Args("f,s*,n#,a##,p[*]", "-f ");
        assertTrue(args.getBoolean('f'));
    }

    @Test
    void shouldReturnFalseWhenGetBoolDoesNotGivenBoolValue() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException, ArgumentTypeException {
        Args args = new Args("f,s*,n#,a##,p[*]", "");
        assertFalse(args.getBoolean('f'));
    }

    @Test
    void shouldThrowArgumentNotExistInSchemaWhenGetBoolGivenArgNotInSchema() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException {
        Args args = new Args("f,s*,n#,a##,p[*]", "-f");
        assertThrows(ArgumentNotExistInSchemaException.class, () ->args.getBoolean('c') );
    }

    @Test
    void shouldThrowArgumentTypeExceptionWhenGetStringGivenArgInSchemaButTypeError() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException {
        Args args = new Args("f,s*,n#,a##,p[*]", "-s 5");
        assertThrows(ArgumentTypeException.class, () ->args.getBoolean('s') );
    }


    @Test
    void shouldReturnTrueWhenGetStringGivenTheArgStringValue() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException, ArgumentTypeException {
        Args args = new Args("f,s*,n#,a##,p[*]", "-s good ");
        assertEquals("good", args.getString('s'));
    }

    @Test
    void shouldReturnFalseWhenGetStringDoesNotGivenStringValue() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException, ArgumentTypeException {
        Args args = new Args("f,s*,n#,a##,p[*]", "");
        assertEquals("", args.getString('s'));
    }
//
//    @Test
//    void shouldThrowArgumentNotExistInSchemaWhenGetStringGivenArgNotInSchema() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException {
//        Args args = new Args("f,s*,n#,a##,p[*]", "-f");
//        assertThrows(ArgumentNotExistInSchemaException.class, () ->args.getBoolean('c') );
//    }
//
//    @Test
//    void shouldThrowArgumentTypeExceptionWhenGetBoolGivenArgInSchemaButTypeError() throws ArgumentNeedValueException, SchemaWrongFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNotExistInSchemaException, ArgumentFormatException {
//        Args args = new Args("f,s*,n#,a##,p[*]", "-s 5");
//        assertThrows(ArgumentTypeException.class, () ->args.getBoolean('s') );
//    }



}
