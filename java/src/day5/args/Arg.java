package day5.args;

import java.util.Map;

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

    void checkValid(Map<Character, String> singleSchemas) throws ArgumentNotExistInSchemaException, ArgumentNeedValueException, BooleanArgumentDoesNotNeedValueException {
        if (!isArgInSchema(singleSchemas)) {
            throw new ArgumentNotExistInSchemaException("args not in schema");
        }
        checkArgValueValid(singleSchemas);
    }

    private boolean isArgInSchema(Map<Character, String> singleSchemas) {
        return singleSchemas.containsKey(name);
    }


    private void checkArgValueValid(Map<Character, String> singleSchemas) throws BooleanArgumentDoesNotNeedValueException, ArgumentNeedValueException {
        if (isBooleanType(singleSchemas) && val != "") {
            throw new BooleanArgumentDoesNotNeedValueException();
        }
        if (!isBooleanType(singleSchemas) && val == "" ) {
            throw new ArgumentNeedValueException();
        }

    }

    private boolean isBooleanType(Map<Character,String> singleSchemas) {
        return singleSchemas.get(name) == "";
    }


}
