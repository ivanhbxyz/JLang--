class NameExpr extends Expr { // Token?
  String id;
  Expr expr;
  
  public NameExpr (String i) {
    id = i;
    expr = null;
  }

  public NameExpr (String i, Expr e) { // would expression be a string or a list or what? would it be some class you import here?
    id = i;
    expr = e;
  }

  public String toString(int t) {
    if (expr != null)
      return "(id: " + id + " [ " + expr.toString(0) + " ]" + ")";
    else
      return "(id: " + id + ")"; // to get tabs or not?
  }

}
