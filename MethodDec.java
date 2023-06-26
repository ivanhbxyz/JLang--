
class MethodDec extends Declaration{

    private String returnType;
    private String id;
    private ArgDeclList argsDecls;

    private FieldDecList fielddecls;
    private StmtList stmts;

    private String optSemi;

    public MethodDec (String t, String i, ArgDeclList args, FieldDecList fl, StmtList ss, String opSem) {
         returnType = t;
         id = i;
         argsDecls = args;
         fielddecls = fl;
         stmts = ss;
         optSemi = opSem;
     }

     public MethodDec (ArgDeclList args, String opSem) { // Field dec list required
        argsDecls = args;
        stmts = null;
        optSemi = opSem;
    }

     
     public MethodDec (String t, String i, ArgDeclList args, String opSem) {
        returnType = t;
        id = i;
        argsDecls = args;
        optSemi = opSem;
    }

 
 
     public String toString(int t){
        String ret = "";
 
        ret += getTabs(t) +  returnType + " " + id + " ( " + argsDecls.toString(0) + " )" + " {\n";
        ret += fielddecls.toString(t+2) + "\n" + 
        stmts.toString(t+2) + "\n" + 
        getTabs(t+1) +  "}" + optSemi;
 
 
         return ret;
     }
     
 }
