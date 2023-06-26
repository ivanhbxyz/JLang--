class CallStmt extends Stmt {
  String id;
  ArgList args;
  
  public CallStmt(String i, ArgList l) {
    id = i;
    args = l;
  }

public CallStmt(String i) {
    id = i;
    args = null;
  }

  public String toString(int t) {
    if (args == null)
      return getTabs(t) + "id: "+ id + "( "+" ) ;\n";
    else
      return getTabs(t) + "id:" + id + " ( " + args.toString(0) + " ) ;\n";
  }
}
