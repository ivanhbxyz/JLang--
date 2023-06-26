class Program extends Token {
  private MemDeclarations memDecs;
  String id;

  public Program(String i, MemDeclarations ms) {
    id = i;
    memDecs = ms;
  }

  public String toString(int t) {
    return "Program:\n" +
    "\t"+ "class "+ id + " { " + "\n" + 
    memDecs.toString(t+1) + "\n" + 
    "\t}";
  }
}
