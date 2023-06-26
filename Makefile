JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

FILE=    Lexer.java parser.java sym.java LexerTest.java ScannerTest.java Token.java Program.java\
		ArgDecl.java Declaration.java ArgDeclList.java MethodDec.java TypeID.java Stmt.java Expr.java\
		MethodArgDecl.java MemDeclarations.java FieldDec.java DataType.java StmtList.java AssignStmt.java\
		TernExpr.java BinExpr.java UnaryExpr.java OperandExpr.java CallExpr.java CastExpr.java FieldDecList.java\
		ArgList.java ReadList.java PrintList.java CallStmt.java IfStmt.java IfElseStmt.java WhileStmt.java\
		IncDecStmt.java ReturnStmt.java ReadStmt.java PrintStmt.java PrintlineStmt.java BracedStmt.java\
		Name.java NameExpr.java

run: Phase2_Tester

all: Lexer.java parser.java $(FILE:java=class)

Phase2_Tester: all
	$(JAVA) -cp $(CP) ScannerTest Phase2_myTester.txt > Phase2_myTester-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java *-output.txt

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
