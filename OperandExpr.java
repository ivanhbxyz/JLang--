class OperandExpr extends Expr {
  String type;
  String value;
  
  public OperandExpr(int i) {
    value = String.valueOf(i);
    type = "int";
  }

  public OperandExpr(double f) {
    value = String.valueOf(f);
    type = "float";
  }

  public OperandExpr(String t, String s) {
    value = s;
    type = t;
  }
  
  public String toString(int t) {
    return "(" + type + ": " + value + ")";
  }
}
