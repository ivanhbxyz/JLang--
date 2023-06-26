class ReadStmt extends Stmt { // is this required?
  ReadList readList;
  
  public ReadStmt(ReadList l) {
    readList = l;
  }

  /*
  public String toString(int t) {
    // What does list.toString(0) accomplish?
    return getTabs(t) + "read(" + 
    readList.toString(0) + ");\n";
  }
  */
  public String toString(int t) {
    String ret = "";
    ret += getTabs(t);
    ret += "read(";
    
    ret += readList.toString(t);

    ret += ");\n";
    return ret;
  }
}
