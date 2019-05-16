package day5.args;


public class ArgumentParser {

    private static final String ARGS_SEPARATOR = " ";
    private static final String ARG_PREFIX = "-";
    String[] argsArr;

    public ArgumentParser(String args) {
         argsArr = args.split(ARGS_SEPARATOR);
    }

     void parser(SchemaRepo repo) throws ArgumentNotExistInSchemaException, ArgumentFormatException, BooleanArgumentDoesNotNeedValueException, ArgumentNeedValueException {
        for (int i = 0; i< argsArr.length; i ++){
            String argStr = argsArr[i];
            String argVal = getArgValue(argsArr, i);
            if (isArgStr(argStr)) {
                new Arg(argStr, argVal).checkValid(repo);
            }
        }
    }

    private boolean isArgStr(String singleArgs) {
        return singleArgs.startsWith(ARG_PREFIX);
    }

    private String getArgValue(String[] argsArr, int i) {
        String argVal = "";
        if (notLastArgs(argsArr, i) && !isArgStr(argsArr[i +1])) {
            argVal = argsArr[i + 1];
        }
        return argVal;
    }

    private boolean notLastArgs(String[] argsArr, int i) {
        return i + 1 < argsArr.length;
    }
}
