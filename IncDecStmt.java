class IncDecStmt extends Stmt {
    Expr expr;
    String op;
    
    public IncDecStmt(Expr e, String o) {
        expr = e;
        op = o;
    }
    
    public String toString(int t) {
        return getTabs(t) +  expr.toString(0) +op +";\n";
    }
}
