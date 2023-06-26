class AssignStmt extends Stmt {
  //String assignee;
  Expr name;
  Expr rhs;
  
  public AssignStmt(Expr n, Expr e) {
    name = n;
    rhs = e;
  }

  public String toString(int t) {
    return getTabs(t) +  name.toString(0) + " = " + rhs.toString(0) + "; \n";
  }
}
