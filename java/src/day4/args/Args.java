package day4.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Args {
    public static final String SCHEMA_SEPARATOR = ",";
    public static final String ARGEMENTS_SEPERATOR = " ";
    public static final String ARG_PREFIX = "-";
    List<String> schemaList = new LinkedList<>();
    List<String> argumentsList = new LinkedList<>();
    public Args(String schema, String arguments) throws Exception {
        if (schema == "" && arguments != ""){
            throw new ArgNotInSchemaException(arguments);
        }

        parserSchema(schema, schemaList);
        parserArguments(arguments, argumentsList);

    }

    private boolean parserArguments(String arguments, List<String> argumentsList) {
        return argumentsList.addAll(Arrays.asList(arguments.split(ARGEMENTS_SEPERATOR)));
    }

    private void parserSchema(String schema, List<String> schemaList) {
        String[] schemaArr = schema.split(SCHEMA_SEPARATOR);
        schemaList.addAll(Arrays.asList(schemaArr));
    }

    public boolean getBool(char c) throws ArgNotInSchemaException {

        if (schemaList.contains(String.valueOf(c))) {
            if (argumentsList.contains(ARG_PREFIX + String.valueOf(c))) {
                return true;
            }
            return false;
        } else {
            throw new ArgNotInSchemaException(String.valueOf(c));
        }
    }

    public String getString(char c) {

        return "";
    }
}
