

public class FieldDec extends Declaration{

    String optFinal;
    
    String type;
    String id;

    String assign;
    
    Expr optExpr;
    
    Integer lit;

    FieldDec(String optF, String t, String i) {
        optFinal = optF;
        type = t;
        id = i;
        optExpr = null;
        assign = "";
        lit = null;
    }

    FieldDec(String optF, String t, String i,String eq, Expr optE) {
        optFinal = optF;
        type = t;
        id = i;
        assign = eq;
        optExpr = optE;
        lit = null;
    }

    FieldDec(String t, String i, int n){
        type = t;
        id = i;
        assign = "";
        lit = n;
    }

    public String toString(int t) {
        String ret = "";

        if(lit != null){
            ret+= getTabs(t) +  type + " " + id + " [ " + lit.toString() + " ] ;";
            return ret;
        }


        if(lit == null && optExpr == null) {

            if(optFinal.length() > 0) {
                ret += getTabs(t) + optFinal + " " + type + " " + id;
            } else {
                ret += getTabs(t) + type + " " + id;
            }

            if(assign.length() > 0) {
                ret += " " + assign + " ";
            }
            
            ret +=" ;";

        } else {

            if(optFinal.length() > 0) {
                ret += getTabs(t) + optFinal + " " + type + " " + id;
            } else {
                ret += getTabs(t) + type + " " + id;
            }

            if(assign.length() > 0) {
                ret += " " + assign + " ";
            }

            ret +="" + optExpr.toString(0) + " ;";
        }

        return ret;

    }
}
