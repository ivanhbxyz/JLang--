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

/**
 * PATTERNS:
 */

tab                 = \\t
newline	            = \\n
slash               = \\ 
escapeapos		    = {slash}'
escapequote		    = {slash}\"
letter      	    = [A-Za-z]
digit       	    = [0-9]
id   			    = {letter}({letter}|{digit})* 
intlit	    	    = {digit}+
floatlit    	    = {intlit}+\.{intlit}+

charchar		    = [[^\\]&&[^']]|{newline}|{tab}|{escapeapos}|{slash}{slash}
charlit     	  = '{charchar}'

stringchar		  = [[[^\\]&&[^\"]]&&[[^\n]&&[^\t]]]|{newline}|{tab}|{escapequote}|{slash}{slash}
stringlit		    = \"{stringchar}*\"
blockcommentS   = {slash}\*
blockcommentE   = \*{slash}

commentbody		  = ([^\*]|(\*+[^\\]))
blockcomment    = {blockcommentS}{commentbody}*?{blockcommentE}
inlinecomment 	= {slash}{slash}.*(\n|\r|\r\n)
whitespace      = [ \n\t\r]

%%
/**
 * LEXICAL RULES:
 */
 
class		{ return newSym(sym.CLASS, "class");}
"&&"		{ return newSym(sym.AND, "&&"); }
else		{ return newSym(sym.ELSE, "else"); }
if			{ return newSym(sym.IF, "if"); }
while		{ return newSym(sym.WHILE, "while"); }
read		{ return newSym(sym.READ, "read"); }
print		{ return newSym(sym.PRINT, "print"); }
printline	{ return newSym(sym.PRINTLN, "printline"); }
return		{ return newSym(sym.RETURN, "return"); }
"||"        { return newSym(sym.OR, "||"); }
"*"         { return newSym(sym.TIMES, "*"); }
"+"         { return newSym(sym.ADD, "+"); }
"++"		{ return newSym(sym.PP, "++"); }
"-"         { return newSym(sym.MINUS, "-"); }
"--"		{ return newSym(sym.MM, "--"); }
"-"		    { return newSym(sym.PREFIXMINUS, "-"); }
"+"         { return newSym(sym.PREFIXPLUS, "+"); }
"/"        	{ return newSym(sym.DIVIDE, "/"); }
";"         { return newSym(sym.SEMICOLON, ";"); }
"("         { return newSym(sym.LPAREN, "("); }
")"         { return newSym(sym.RPAREN, ")"); }
"{"		    { return newSym(sym.LBRACE, "{"); }
"}"		    { return newSym(sym.RBRACE, "}"); }
"["         { return newSym(sym.LBRACK, "["); }
"]"        	{ return newSym(sym.RBRACK, "]"); }
"=="        { return newSym(sym.EQUALS, "=="); }
">"        	{ return newSym(sym.GTHAN, ">"); }
"<"         { return newSym(sym.LTHAN, "<"); }
"<="        { return newSym(sym.LEQ, "<="); }
">="        { return newSym(sym.GEQ, ">="); }
"<>"        { return newSym(sym.NOTEQ, "<>"); }
"~"			{ return newSym(sym.TILDA, "~"); }
"?"			{ return newSym(sym.QUESTION, "?"); }
":"         { return newSym(sym.COLON, ":"); }
"="         { return newSym(sym.ASSIGN, "="); }
","		    { return newSym(sym.COMMA, ","); }
final 		{ return newSym(sym.FINAL, "final"); }
void		{ return newSym(sym.VOID, "void"); }
int		    { return newSym(sym.INT, "int"); }
float		{ return newSym(sym.FLOAT, "float"); }
bool		{ return newSym(sym.BOOL, "bool"); }
char		{ return newSym(sym.CHAR, "char"); }

true		{ return newSym(sym.TRUE, "true"); }
false		{ return newSym(sym.FALSE, "false"); }

{id}        { return newSym(sym.ID, yytext()); }
{intlit}    { return newSym(sym.INT_LIT, new Integer(yytext())); }
{floatlit}  { return newSym(sym.FLOAT_LIT, new Double(yytext())); }
{charlit}   { return newSym(sym.CHAR_LIT, yytext()); }
{stringlit}	{ return newSym(sym.STRING_LIT, yytext()); }

{inlinecomment} { /* For this stand-alone lexer, print out comments. */}
{blockcomment}	{ /* For this stand-alone lexer, print out comments. */}
{whitespace}    { /* Ignore whitespace. */ }
.               { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); }