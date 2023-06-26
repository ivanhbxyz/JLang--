import java.util.List;
import java.util.LinkedList;

class StmtList extends Token {
  private List<Stmt> stmts;
  
  public StmtList() {
    stmts = new LinkedList<Stmt>();
  }

  public StmtList prependStmt(Stmt s) {
    stmts.add(0,s);
    return this;
  }

/* WHY
  public StmtList append(Stmt s) {
    stmts.add(s);
    return this;
  }
  */

  public String toString(int t) {
    String ret = "";
  
    for (Stmt s : stmts) {
      //ret += getTabs(t); // DOES THIS BREAK ANYTHING GLOBALLY? WATCH OUT
      ret += s.toString(t);
      //ret += getTabs(t); // DOES THIS BREAK ANYTHING GLOBALLY?
    }
    return ret;
  }
  
}
