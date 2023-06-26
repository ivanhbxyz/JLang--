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

FILE=    Lexer.java      parser.java    sym.java \
    LexerTest.java

run: myLexerRun

all: Lexer.java parser.java $(FILE:java=class)

myLexerRun: all
		$(JAVA) -cp $(CP) LexerTest ./test-files/basicFails.txt > ./test-files/basicFails-output.txt
		$(JAVA) -cp $(CP) LexerTest ./test-files/basicRegex.txt > ./test-files/basicRegex-output.txt
		$(JAVA) -cp $(CP) LexerTest ./test-files/basicTerminals.txt > ./test-files/basicTerminals-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java *-output.txt ./test-files/*-output.txt

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
