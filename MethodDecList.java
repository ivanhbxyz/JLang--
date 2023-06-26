import java.util.List;
import java.util.LinkedList;

class MethodDecList extends Token{
  
  private List<Declaration> memDecs;

  public MethodDecList() {
    memDecs = new LinkedList<Declaration>();
  }
    
  public MethodDecList prepend(Declaration d) {
    memDecs.add(0,d);
    return this;
  }
    
    
  public String toString(int t) {
    String ret = "";
      
    for (Declaration d : memDecs) {
      ret+="\n";
      ret += d.toString(t);
      ret += "\n";
    }

    return ret;
  }

}