public class BracedStmt extends Stmt {
  
  private FieldDecList fielddecls;
  StmtList ss;
  String semi;

  public BracedStmt (FieldDecList fl, StmtList s, String optSem) {
    ss = s;
    fielddecls = fl;
    semi = optSem;
  }

  public String toString(int t) {
    String ret = "";
    ret += getTabs(t);

    if(semi.length() < 1){
        ret += "{\n";
        ret += fielddecls.toString(t+1);
        ret += ss.toString(t+1);
        ret += getTabs(t);
        ret += "}" + semi;
        ret += "\n";
    } else {
        ret += "{\n";
        ret += fielddecls.toString(t+1);
        ret += ss.toString(t+1);
        ret += getTabs(t);
        ret += "}" + semi;
        ret += "\n";
        
    }
    

    return ret;
  }


}