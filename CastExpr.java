class CastExpr extends Expr {
  Expr expr;
  String type;
  
  public CastExpr(Expr e) { // to obtain the simple parenthesis -> (((Expr)))
    expr = e;
  }
  
  public CastExpr(String s, Expr e) {
    expr = e;
    type = s;
  }
  
  public String toString(int t) {
    
    String ret = "";

    if(type == null) {
      ret += getTabs(t) + "(";
      ret += expr.toString(0);
      ret += ")";
    } else {

      ret += getTabs(t) + "((" + type + ") ";
      ret += expr.toString(0);
      ret += ")";
    }

    
    return ret;
  }

}
  