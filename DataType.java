class DataType extends Token {


    String type;

    public DataType(String s){
        type = s;
    }

    public String toString(int t) {
        return getTabs(0) + type;
    }

    
}
