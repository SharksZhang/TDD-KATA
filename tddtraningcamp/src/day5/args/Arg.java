package day5.args;


public class Arg {
    Character name;
    String val;

    public Arg(String argStr, String argVal) throws ArgumentFormatException {
        if (!isArgLengthValid(argStr)) {
            throw new ArgumentFormatException();
        }
        name = argStr.charAt(1);
        val = argVal;
    }

    private boolean isArgLengthValid(String argStr) {
        return argStr.length() == 2;
    }

    void checkValid(SchemaRepo repo) throws ArgumentNotExistInSchemaException, ArgumentNeedValueException, BooleanArgumentDoesNotNeedValueException {
        if (!repo.isSchemaExist(name)) {
            throw new ArgumentNotExistInSchemaException("args not in schema");
        }
        checkArgValueValid(repo);
    }



    private void checkArgValueValid(SchemaRepo repo) throws BooleanArgumentDoesNotNeedValueException, ArgumentNeedValueException {

        if (repo.get(name).isBoolType() && !val.equals("")) {
            throw new BooleanArgumentDoesNotNeedValueException();
        }

        if (!repo.get(name).isBoolType() && val.equals("")  ) {
            throw new ArgumentNeedValueException();
        }

    }



}
