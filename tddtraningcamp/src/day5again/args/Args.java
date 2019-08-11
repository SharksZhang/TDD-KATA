package day5again.args;

public class Args {
	ArgsParser argsParser;
	SchemaParser schemaParser;
    public Args(String schema, String args) throws Exception {
    	schemaParser = new SchemaParser(schema);
		argsParser = new ArgsParser(args);
    }

    public boolean getBool(String flag) throws Exception {
		if (!schemaParser.isBool(flag)) {
			throw new Exception("flag type error");
		}
		return argsParser.get(flag);
	}
}
