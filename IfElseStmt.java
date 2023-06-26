class IfElseStmt extends Stmt {
  private Expr expr;
  private StmtList stmts1;
  private FieldDecList fielddecls1;
  private StmtList stmts2;
  private FieldDecList fielddecls2;

  public IfElseStmt(Expr e, FieldDecList ff, StmtList ss,  FieldDecList fs,  StmtList tt) {
    expr = e;
    fielddecls1 = ff;
    stmts1 = ss;
    fielddecls2 = fs;
    stmts2 = tt;
  }


  public String toString(int t) {
    String ret = "";

    ret =getTabs(t)+ "if ( " + expr.toString(0) + " ) " + "{\n";
    ret += fielddecls1.toString(t+1) + "\n";
    ret += stmts1.toString(t+1);
    ret +=getTabs(t);
    ret += "} else {\n";
    ret += fielddecls2.toString(t+1) + "\n";
    ret += stmts2.toString(t+1);
    ret += getTabs(t);
    ret += "}\n\n";
    return ret;
  }
}