class Name extends Expr { // Token?
  String id;
  Expr expr;
  
  public Name (String i) {
    id = i;
    expr = null;
  }

  public Name (String i, Expr e) { // would expression be a string or a list or what? would it be some class you import here?
    id = i;
    expr = e;
  }

  /*
  // What does getTabs do?
  public String toString(int t) {
    if (expr != null)
      return getTabs(t) + id + " [ " + expr.toString(0) + " ]"; // is the expr.toString implemented correctly?
    else
      return getTabs(0) + id;
  } // WHAT CONSTRUCT SHOULD EXPRESSION HAVE?!?
  */
    // What does getTabs do?
  public String toString(int t) {
    if (expr != null)
      return id + " [ " + expr.toString(0) + " ]"; // is the expr.toString implemented correctly?
    else
      return id; // to get tabs or not?
  } // WHAT CONSTRUCT SHOULD EXPRESSION HAVE?!?

}
