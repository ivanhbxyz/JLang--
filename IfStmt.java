
public class IfStmt extends Stmt {
    
   
    private Expr expr;
    private FieldDecList fielddecls;
    private StmtList stmts;
    
    public IfStmt(Expr e, FieldDecList ff, StmtList list) {
        
        
        expr = e;
        fielddecls = ff;
        stmts = list;
    }
    public String toString(int t) {
        String ret = "";
        ret += getTabs(t) +  "if ( " + expr.toString(0) + " ) " + "{\n";
       // ret += getTabs(t);
       ret += fielddecls.toString(t+1) + "\n";
        ret += stmts.toString(t+1); // works well
        ret += getTabs(t);
        ret+= "}\n";
        
        return ret;
    }
    
}