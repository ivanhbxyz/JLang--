import java.util.List;
import java.util.LinkedList;

class FieldDecList extends Token{

    private List<Declaration> fieldDecs;

  public FieldDecList() {
      fieldDecs = new LinkedList<Declaration>();
  }
    
  public FieldDecList prepend(Declaration d) {
    fieldDecs.add(0,d);
    return this;
  }
  
  public String toString(int t) {
    String ret = "";
    
    for (Declaration f : fieldDecs) {

        ret += f.toString(t);
        ret+= "\n";

    }
    
      return ret;
  }

}
