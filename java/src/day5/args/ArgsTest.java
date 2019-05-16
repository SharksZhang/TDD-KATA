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

    @Disabled
    void shouldThrowArgsValueTypeExceptionGivenArgsValueWrong() {
        assertThrows(WrongArgsTypeException.class, () -> new Args("f,s*,n#,a##,p[*]", "-s @@@"));
    }







}
