import java.util.LinkedList;
import java.util.List;

class MemDeclarations extends Token{

  private List <Declaration> mems;

  public MemDeclarations() { // Does this always execute?
    mems = new LinkedList<Declaration>();
  }


  public MemDeclarations prepend(Declaration m) {
    
    mems.add(0,m);
    return this;
  }

    
  public String toString(int t) {
    String ret = "";
    
    if(mems.size() > 0)
      ret+="\n";

    for (Declaration d : mems){
      ret += getTabs(t);
      ret += d.toString(t) + "\n";
    }
      
    return ret;

    }
}
