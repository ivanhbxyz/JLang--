public class PrintStmt extends Stmt {
  PrintList pl;
  public PrintStmt(PrintList p) {
    pl = p;
  }
  
  public String toString(int t) {

    return getTabs(t)+ "print( " + pl.toString(0) + " );\n";
    }
}