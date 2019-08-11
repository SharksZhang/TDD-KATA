package day5again.args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchemaParserTest {

	@Test
	void should_return_true_when_flag_exist_in_schema() throws Exception {
		SchemaParser schemaParser = new SchemaParser("a");
		assertTrue(schemaParser.isBool("a"));
	}

	@Test
	void should_return_true_given_Three_flags_when_flag_exist_in_schema() throws Exception {
		SchemaParser schemaParser = new SchemaParser("a,b,c");
		assertTrue(schemaParser.isBool("b"));
	}

	@Test
	void should_return_false_when_flag_not_exist() throws Exception {
		SchemaParser schemaParser = new SchemaParser("a,b,c");
		assertFalse(schemaParser.isBool("d"));
	}

	@Test
	void should_throw_exception_when_schema_format_error() {
		assertThrows(Exception.class, () -> new SchemaParser("aa,b,c"));

	}

	@Test
	void should_throw_exception_when_schema_format_error1() {
		assertThrows(Exception.class, () -> new SchemaParser("-,b,c"));

	}

	@Test
	void should_not_throw_exception_when_schema_is_null() {
		assertDoesNotThrow(() -> new SchemaParser(""));

	}

	@Test
	void should_not_throw_exception_given_string_schema() throws Exception {
		  assertDoesNotThrow(() -> new SchemaParser("a*"));

	}

	@Test
	void should_return_true_when_is_string() throws Exception {
		SchemaParser schemaParser = new SchemaParser("a*");
		assertTrue(schemaParser.isString("a"));
	}

	@Test
	void should_return_false_when_does_not_given_string() throws Exception {
		SchemaParser schemaParser = new SchemaParser("a");
		assertFalse(schemaParser.isString("a"));
	}




}