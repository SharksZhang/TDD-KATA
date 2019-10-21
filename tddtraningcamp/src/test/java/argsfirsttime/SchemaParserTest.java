package argsfirsttime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchemaParserTest {
	@Test
	void shouldReturnTrueWhenFlagExistInSchema() throws Exception {
		SchemaParser schemaParser = new SchemaParser("a,b");
		assertTrue(schemaParser.isBool("a"));
		assertTrue(schemaParser.isBool("b"));
		assertFalse(schemaParser.isBool("c"));
	}

	@Test
	void shouldThrowExceptionWhenSchemaFormatError() {
		assertThrows(Exception.class, () -> new SchemaParser("ab"));
	}

	@Test
	void shouldThrowExceptionWhenSchemaFormatError2() {
		assertThrows(Exception.class, () -> new SchemaParser("a, b"));
	}

	@Test
	void shouldThrowExceptionWhenSchemaFormatError3() {
		assertThrows(Exception.class, () -> new SchemaParser("*"));
	}





}