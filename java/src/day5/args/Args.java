package day5.args;


import java.util.List;

public class Args {
    SchemaRepo schemaRepo = new SchemaRepo();
    ArgRepo argRepo = new ArgRepo();

    public Args(String schema, String args) throws SchemaWrongFormatException,
            ArgumentNotExistInSchemaException, ArgumentFormatException,
            BooleanArgumentDoesNotNeedValueException, ArgumentNeedValueException {

        List<Schema> schemas = new SchemaParser(schema).parser();
        for (Schema s : schemas) {
            schemaRepo.add(s);
        }
        List<Arg> argList = new ArgumentParser(args).parser(schemaRepo);
        for (Arg arg : argList) {
            argRepo.add(arg);
        }
    }

    public boolean getBoolean(char f) throws ArgumentNotExistInSchemaException, ArgumentTypeException {
        if (schemaRepo.get(f) == null){
            throw new ArgumentNotExistInSchemaException("");
        }
        if (!schemaRepo.get(f).isBoolType()) {
            throw new ArgumentTypeException();
        }
        if (argRepo.get(f) != null) {
            return true;
        }
        return false;
    }

    public String getString(char s) {
        return argRepo.get(s).val;
    }
}

