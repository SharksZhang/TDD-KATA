package day5.args;


import java.util.List;

public class Args {
    SchemaRepo schemaRepo = new SchemaRepo();

    public Args(String schema, String args) throws SchemaWrongFormatException,
            ArgumentNotExistInSchemaException, ArgumentFormatException,
            BooleanArgumentDoesNotNeedValueException, ArgumentNeedValueException {

        List<Schema> schemas = new SchemaParser(schema).parser();
        for (Schema s : schemas) {
            schemaRepo.add(s);
        }
        new ArgumentParser(args).parser(schemaRepo);
    }
}

