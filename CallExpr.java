class CallExpr extends Expr {
  String id;
  ArgList args;
  
  public CallExpr(String i, ArgList l) {
    id = i;
    args = l;
  }

  public String toString(int t) {
    
    String ret = "";

    /*
    if (args.size() > 0) {
    for (Expr e : args) {
      ret += e.toString(0) + " ,";
    }
    
    //ret += i + " ,";
    ret = ret.substring(0, (ret.length() - 2));
    }
    */
    ret += getTabs(t) + "(id: " + id +"(";

    ret += args.toString(0);
    
    ret += "))";

    return ret;
  }
}
