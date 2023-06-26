public class PrintlineStmt extends Stmt {
  
  PrintList pl;
  
  public PrintlineStmt() {
    pl = null;
  }

  public PrintlineStmt(PrintList p) {
    pl = p;
  }


  public String toString(int t) {
    String ret = "";
    if(pl != null) {
      ret += getTabs(t);
      ret += "printline( ";
      ret += pl.toString(t);
      ret += " );\n";
    } else {
      ret += getTabs(t);
      ret += "printline();\n";
    }
    return ret;
  }
}