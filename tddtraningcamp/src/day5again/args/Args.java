package day5again.args;

public class Args {
	ArgsParser argsParser;
    public Args(String schema, String args) throws Exception {
		argsParser = new ArgsParser(args);
    }

    public boolean getBool(String flag) {
		return argsParser.get(flag);
    }
}
