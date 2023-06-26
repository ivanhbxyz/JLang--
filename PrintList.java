import java.util.List;
import java.util.LinkedList;

class PrintList extends Token {
  private List<Expr> pl;
  
  public PrintList() {
    pl = new LinkedList<Expr>();
  }

  public PrintList(Expr e) {
    pl = new LinkedList<Expr>();
    pl.add(e);
  }

  public PrintList prependExpr(Expr e) {
    pl.add(0,e);
    return this;
  }
  
  /*
  public ReadList appendName(Expr n) {
    rl.add(n);
    return this;
  }
  */

  public String toString(int t) { // why do you take in an arugment and not use it?
    String ret = "";
    
    for (Expr e : pl) {
      ret += e.toString(0) + " ,";
    }
    
    //ret += i + " ,";
    if (pl.size() > 0) {
     ret = ret.substring(0, (ret.length() - 2));
    } else {
      ret = ret.substring(0, ret.length());
    }

    return ret;
  }



}