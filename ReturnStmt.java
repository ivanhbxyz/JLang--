class ReturnStmt extends Stmt {
    Expr expr;
    
    public ReturnStmt(Expr e) {
        expr = e;
    }
    
    public ReturnStmt() {
        expr = null;
    }
    
    public String toString(int t) {
        if(expr == null)
            return getTabs(t)+"return ;\n";
        else
            return getTabs(t)+ "return " +  expr.toString(0) + " ;\n";
    }
}
