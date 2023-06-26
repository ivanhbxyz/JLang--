class WhileStmt extends Stmt {
  
  StmtList stmts;
  Expr expr;
  
  public WhileStmt(Expr e, StmtList l) {
    stmts = l;
    expr = e;
  }

  public String toString(int t) {
    return getTabs(t) + "while (" + expr.toString(0) + ") {\n" +
      stmts.toString(t+1) + getTabs(t) + "}\n";
  }
}
