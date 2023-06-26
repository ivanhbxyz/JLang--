/*-***
 *
 * This file defines a stand-alone lexical analyzer for a subset of the Pascal
 * programming language.  This is the same lexer that will later be integrated
 * with a CUP-based parser.  Here the lexer is driven by the simple Java test
 * program in ./PascalLexerTest.java, q.v.  See 330 Lecture Notes 2 and the
 * Assignment 2 writeup for further discussion.
 *
 */


import java_cup.runtime.*;


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer

%{

StringBuffer string = new StringBuffer();

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

%}


/*-*
 * PATTERN DEFINITIONS:
 */

/**
 * Implement patterns as regex here
 */

LineTerminator = \r |\n |\r\n
// does not allow for \n
Letter = [[[^\n]&&[^\t]]&&[[^\\][^\"]]]|\\\\|\\\"

whitespace = {LineTerminator} | [ \t\f] | [\ \t] | [ \t\n\r]

TraditionalComment   = "\\*" [^*] ~"*\\" | "\\*" "*"+ "\\"

// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "\\" {Letter}* {LineTerminator}?

Comment = {TraditionalComment} | {EndOfLineComment}

Digit = [0-9]
//Integer = 0 | [1-9][0-9]* //an integer literal has a digit followed by zero or more digits
Integer = {Digit}+

id = [a-zA-Z][[a-zA-Z]|[0-9]]* // an identifier has a leading letter followed by zero or more letters or digits

Character = '\\t' | '\\n' | '\\r' | '\\'' | '\\b' | '\\v' | '{Letter}' | '{Digit}'

Float = {Digit}+\.{Digit}+

StringChar=\\t|\\n|\\\\|\\\"|[[[^\n]&&[^\t]]&&[^\\\"]]
String = \"{StringChar}*\"



//%state STRING

%%
/**
 * LEXICAL RULES:
 */

/**
 * Implement TERMINALS here, ORDER MATTERS!
 */

<YYINITIAL> {

"class"         {return newSym(sym.CLASS, "class");}
"void"          {return newSym(sym.VOID, "void");}
"while"         {return newSym(sym.WHILE, "while");}
"if"            {return newSym(sym.IF, "if");}
"else"          {return newSym(sym.ELSE, "else");}
"read"          {return newSym(sym.READ, "read");}
"return"        {return newSym(sym.RETURN, "return");}
"print"         {return newSym(sym.PRINT, "print");}
"printline"     {return newSym(sym.PRINTLINE, "printline");}
"final"         {return newSym(sym.FINAL, "final");}
"int"           {return newSym(sym.INT, "int");}
"char"          {return newSym(sym.CHAR, "char");}
"bool"          {return newSym(sym.BOOL, "bool");}
"float"         {return newSym(sym.FLOAT, "float");}

true            {return newSym(sym.BOOL_LIT, yytext());}
false           {return newSym(sym.BOOL_LIT, yytext());}

//{String}              { string.setLength(0); yybegin(STR_LIT); }
{String}     {return newSym(sym.STR_LIT, yytext());}

"{"             {return newSym(sym.LBRACE, "{");}
"}"             {return newSym(sym.RBRACE, "}");}
"["             {return newSym(sym.LBRACK, "[");}
"]"             {return newSym(sym.RBRACK, "]");}
"("             {return newSym(sym.LPAREN, "(");}
")"             {return newSym(sym.RPAREN, ")");}
","             {return newSym(sym.COMMA, ",");}
";"             {return newSym(sym.SEMICOLON,";");}

"="             {return newSym(sym.EQUALS, "=");}
"?"             {return newSym(sym.QUESTION, "?");}
":"             {return newSym(sym.COLON, ":");}
"~"             {return newSym(sym.TILDA, "~");}
"--"            {return newSym(sym.MM, "--");}
"++"            {return newSym(sym.PP, "++");}
"-"             {return newSym(sym.SUBTRACT, "-");}
"+"             {return newSym(sym.ADD, "+");}
"*"             {return newSym(sym.MULTIPLY, "*");}
"/"             {return newSym(sym.DIVIDE, "/");}
"<"             {return newSym(sym.LTHAN, "<");}
">"             {return newSym(sym.GTHAN, ">");}
"<="            {return newSym(sym.LEQ, "<=");}
">="            {return newSym(sym.GEQ, ">=");}
"<>"            {return newSym(sym.DIAMOND, "<>");}
"&&"            {return newSym(sym.AND, "&&");}
"||"            {return newSym(sym.OR, "||");}



{Float}         {return newSym(sym.FLOAT_LIT, yytext());}
{Integer}       {return newSym(sym.INT_LIT, new Integer(yytext()));}
{Character}     {return newSym(sym.CHAR_LIT, yytext());}


{Comment}       { /* Ignore comment construct */ }


{whitespace}    { /* Ignore whitespace. */ }
.               { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); }
    
{id}            {return newSym(sym.ID, yytext());}


}


//<STRING> {
//      \"                    { yybegin(YYINITIAL); return symbol(STRING_LITERAL, string.toString()); }
//    [^\n\r\"\\]+            { string.append( yytext() ); }

//    \\t                     { string.append('\t'); }
//    \\n                     { string.append('\n'); }
//    \\r                     { string.append('\r'); }
//    \\\"                    { string.append('\"'); }
//    \\                      { string.append('\\'); }
//}
