/*
abstract class PrintlineList extends PrintList {
}
*/

/*
import java.util.List;
import java.util.LinkedList;

class PrintlineList extends Token {
  private List<Expr> pl;
  
  public PrintlineList() {
    pl = new LinkedList<Expr>();
  }

  public PrintlineList(Expr e) {
    pl = new LinkedList<Expr>();
    pl.add(e);
  }

  public PrintList prependExpr(Expr e) {
    pl.add(0,e);
    return this;
  }
  

  public String toString(int t) { // why do you take in an arugment and not use it?
    String ret = "";
    
    for (Expr e : pl) {
      ret += e.toString(0) + " ,";
    }
    
    //ret += i + " ,";
    ret = ret.substring(0, (ret.length() - 2));

    return ret;
  }



}
*/

import java.util.List;
import java.util.LinkedList;

class PrintlineList extends Token {
  private List<Expr> pl;
  
  public PrintlineList() {
    pl = new LinkedList<Expr>();
  }

  public PrintlineList(Expr e) {
    pl = new LinkedList<Expr>();
    pl.add(e);
  }

  public PrintlineList prependExpr(Expr e) {
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
    

    if (pl.size() > 0) {
    for (Expr e : pl) {
      ret += e.toString(0) + " ,";
    }

    ret = ret.substring(0, (ret.length() - 2));
    }

    return ret;
  }



}