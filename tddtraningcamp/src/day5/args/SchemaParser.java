package day5.args;

import java.util.ArrayList;
import java.util.List;

public class SchemaParser {
    public static final String SCHEMA_SEPARATOR = ",";
    String[] schemas;

    public SchemaParser(String schema) throws SchemaWrongFormatException {
        if (schema == "") {
            throw new SchemaWrongFormatException("schema is null");
        }
        schemas = schema.split(SCHEMA_SEPARATOR);

    }

    List<Schema> parser() throws SchemaWrongFormatException {
        List<Schema> schmeas = new ArrayList<>();
        for (String singleSchema : schemas) {
            schmeas.add(parseSingleSchema(singleSchema));
        }
        return schmeas;
    }

    private Schema parseSingleSchema(String schema) throws SchemaWrongFormatException {
        char flagName = schema.charAt(0);
        String flagType = "";

        if (schema.length() > 1) {
            flagType = schema.substring(1);
        }
        Schema s = new Schema(flagName, flagType);
        s.checkValid();
        return s;
    }
}
