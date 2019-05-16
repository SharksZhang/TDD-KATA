package day5.args;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Args {

    public static final String SCHEMA_SEPARATOR = ",";
    SchemaRepo schemaRepo = new SchemaRepo();
    Map<Character, String> singleSchemas = new HashMap<>();


    public Args(String schema, String args) throws SchemaWrongFormatException, ArgumentNotExistInSchemaException, ArgumentFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNeedValueException {
        if (schema == "") {
            throw new SchemaWrongFormatException("schema is null");
        }
        for (String singleSchema : schema.split(SCHEMA_SEPARATOR)) {
            parseSingleSchema(singleSchema);
        }
        List<Schema> schemas = new SchemaParser(schema).parser();
        for (Schema s : schemas) {
            schemaRepo.add(s);
        }
        new ArgumentParser(args).parser(singleSchemas);
    }


    private void parseSingleSchema(String schema) throws SchemaWrongFormatException {
        char flagName = schema.charAt(0);
        String flagType = "";

        if (schema.length() >1){
            flagType = schema.substring(1);
        }
        if (flagType == "") {

        }else if(flagType.equals("*") ) {

        }else if(flagType.equals("#")){

        }else if(flagType.equals("##")){

        }else if(flagType.equals("[*]")){

        } else {
            throw new SchemaWrongFormatException();
        }
        if (singleSchemas.containsKey(flagName)){
            throw new SchemaWrongFormatException("flag duplicate");
        }
        singleSchemas.put(flagName, flagType);
    }
}

