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

FILE=    Lexer.java parser.java sym.java\
	LexerTest.java ScannerTest.java Token.java Program.java Expr.java\
	Name.java Stmt.java AssignStmt.java StmtList.java OperandExpr.java\
	BinExpr.java TernExpr.java UnaryExpr.java Arg.java ArgList.java CallExpr.java\
	CallStmt.java IfStmt.java IfElseStmt.java WhileStmt.java ReturnStmt.java\
	ReadList.java ReadStmt.java PrintStmt.java PrintlineStmt.java PrintList.java\
	BracedStmt.java CastExpr.java NameExpr.java MemDecList.java FieldDec.java\
	MethodDec.java


run: Phase1_expressions Phase1_statements Phase1_order_of_ops

all: Lexer.java parser.java $(FILE:java=class)

Phase1_expressions: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_expressions.txt > Phase1_expressions-output.txt

Phase1_statements: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_statements.txt > Phase1_statements-output.txt

Phase1_order_of_ops: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_order_of_ops.txt > Phase1_order_of_ops-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java *-output.txt

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
