class TernExpr extends Expr {
  Expr e1;
  Expr e2;
  Expr e3;
  
  public TernExpr(Expr one, Expr two, Expr three) {
    e1 = one;
    e2 = two;
    e3 = three;
  }

  public String toString(int t) {
    return getTabs(t) + "(" + "(" + e1.toString(0) +")" + " ? " +
        "(" + e2.toString(0) + ")" + " : " +"(" +  e3.toString(0) + ")" 
        + ")";
  }
}
