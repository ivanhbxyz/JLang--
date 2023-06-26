class ArgDecl extends MethodArgDecl {

    private String type;
    private String id;
    private boolean parenn;

    public ArgDecl(String t, String i) {
        type = t;
        id = i;
    }


    public ArgDecl(String t, String i, boolean p) {
        type = t;
        id = i;
        parenn = p;
    }



    public String toString(int t) {

        if(parenn)
            return getTabs(t) + type +" " + id + "[]";
        else
            return getTabs(t) + type + " "+ id;
    }
    
}
