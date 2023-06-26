import java.util.List;
import java.util.LinkedList;

class ArgDeclList extends Token {
  private List<MethodArgDecl> args;

  public ArgDeclList() { // del
    args = new LinkedList<MethodArgDecl>();
  }
  
  public ArgDeclList(MethodArgDecl a) { // del
    args = new LinkedList<MethodArgDecl>();
    args.add(a);
  }

  public ArgDeclList prependArg(MethodArgDecl a) {
    args.add(0,a);
    return this;
  }
  
  public String toString(int t) {
    String ret = "";
    
    if(args.size() > 0) {
      for (MethodArgDecl i : args) {
        ret += i.toString(0) + ", ";
      }
      ret = ret.substring(0, (ret.length() -2));
    }

    
    return ret;
  }
}
