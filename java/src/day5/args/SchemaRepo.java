package day5.args;

import java.util.HashMap;
import java.util.Map;

public class SchemaRepo {
    Map<Character, Schema> repo = new HashMap<>();



    public void add(Schema schema) throws SchemaWrongFormatException {
        if (repo.containsKey(schema.getName())){
            throw new SchemaWrongFormatException("flag duplicate");
        }
        repo.put(schema.getName(), schema);
    }

}
