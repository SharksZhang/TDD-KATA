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

	public String getString(String flag) throws Exception {
		if(!schemaParser.isString(flag)){
			throw new Exception("flag Type error");
		}
		return argsParser.getString(flag);
	}


	public int getInteger(String flag) throws Exception {
		if (!schemaParser.isInteger(flag)) {
			throw new Exception("flag Type error");
		}
		return argsParser.getInteger(flag);
	}

	public double getDouble(String flag) throws Exception {
		if (!schemaParser.isDouble(flag)) {
			throw new Exception("flag type error");
		}
		return argsParser.getDouble(flag);
	}
}



