class TypeID extends Token {

    String type;
    String id;

    public TypeID(String t, String i) {
        type = t;
        id = i;
    }

    public String getType() {
        return type;
    }
    
    public String getID() {
        return id;
    }

    public String toString(int t) {
        String ret = "";

        ret = getTabs(0) + type + " " + id + " ";
        return ret;
    }
    
}
