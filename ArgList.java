import java.util.List;
import java.util.LinkedList;

class ArgList extends Token {
  private List<Expr> args;
  
  public ArgList() {
    args = new LinkedList<Expr>();
  }

  public ArgList(Expr e) { // del
    args = new LinkedList<Expr>();
    args.add(e);
  }

  public ArgList prependArg(Expr e) {
    args.add(0,e);
    return this;
  }

  /*
  public ArgList join(ArgList i) {
    args.addAll(i.args);
    return this;
  }
  */
  
  public String toString(int t) {
    String ret = "";
    
    if(args.size() > 0) {
      for (Expr i : args) {
        ret += i.toString(0) + " ,";
      }
      ret = ret.substring(0, (ret.length()-2));
    }
    
    return ret;
  }

  /*
  public String toString(int t) {
    String ret = "";
    for (Arg e : args) {
      ret += e.toString(0) + " ," ;
    }
    return ret;
  }
  */

}