import java.util.List;
import java.util.LinkedList;

class ReadList extends Token {
  private List<Expr> rl;
  
  public ReadList() {
    rl = new LinkedList<Expr>();
  }

  public ReadList(Expr n) {
    rl = new LinkedList<Expr>();
    rl.add(n);
  }

  
  public ReadList prependName(Expr n) {
    rl.add(0,n);
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
    
    for (Expr i : rl) {
      ret += i.toString(0) + " ,";
    }
    
    //ret += i + " ,";
    ret = ret.substring(0, (ret.length() - 2));

    return ret;
  }



}


/*
import java.util.List;
import java.util.LinkedList;

class ReadList extends Token {
  private List<String> rl;
  
  public ReadList() {
    rl = new LinkedList<String>();
  }

  public ReadList prependName(String n) {
    rl.add(0,n);
    return this;
  }

  public ReadList appendName(String n) {
    rl.add(n);
    return this;
  }

  public String toString(int t) { // why do you take in an arugment and not use it?
    String ret = "";

    for (String i : rl) {
      ret += i + " ,";
    }
    ret = ret.substring(0, (ret.length() - 2));

    return ret;
  }
}
*/
