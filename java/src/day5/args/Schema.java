package day5.args;

public class Schema {
    private  char Name;
    private String type;

    public char getName() {
        return Name;
    }

    public String getType() {
        return type;
    }

    public Schema(char name, String type) {
        this.Name = name;
        this.type = type;
    }

    public boolean isBoolType() {
        return type == "";
    }

    public boolean isStringType() {
        return type.equals("*");
    }

    public boolean isIntegerType() {
        return type.equals("#");
    }

    public boolean isDoubleType() {
        return type.equals("##");
    }

    public boolean isStringArrayType() {
        return type.equals("[*]");
    }

    void checkValid() throws SchemaWrongFormatException {
        if (this.type == "") {

        }else if(this.type.equals("*") ) {

        }else if(this.type.equals("#")){

        }else if(this.type.equals("##")){

        }else if(this.type.equals("[*]")){

        } else {
            throw new SchemaWrongFormatException();
        }
    }
}
