# JLang--





### Requirements
- Java
- [JFlex](https://github.com/jflex-de/jflex/releases)
- Make
- [CUP](http://www2.cs.tum.edu/projects/cup/install.php)

### Project Structure

```
JLang--
    - java-cup-11b-runtime.jar
    - java-cup-11b.jar
    - jflex-full-1.8.2.jar
    - LexerTest.java
    - Makefile
    - README.md
    - tokens.jflex
    - grammar.cup
    - <classes>.java
    - test-files
        |
        - <testName>.txt
    
```


To run project:
	If wanting to re-make the output-*.txt files run; in your terminal run

	$ make clean
	
	To re-run and compile Lexer, parser and sym files in your terminal run.

	$ make

===============

The following files should have been created

basicTerminals-output.txt
basicRegex-output.txt
basicFails-output.txt

=================

To Remove output files:

	make clean