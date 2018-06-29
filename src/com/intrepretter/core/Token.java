package com.intrepretter.core;

public class Token {
final TokenType ttype;
final String lexeme;
final Object literal;
final int line;

    public Token(TokenType ttype, String lexeme, Object literal, int line) {
        this.ttype = ttype;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }
}



enum TokenType{

    //One
    LEFT_PAREN,RIGHT_PAREN,LEFT_BRACE,RIGHT_BRACE,
    COMMA,DOT,MINUS,PLUS,SEMICOLON,SLASH,STAR,

    //One or More
    BANG,BANG_EQUAL,
    EQUAL,EQUAL_EQUAL,
    GREATER,GREATER_EQUAL,
    LESSER,LESSER_EQUAL,

    //Keywords
    AND,CLSS,VAR,ELSE,TRUE,FALSE,FUN,FOR,IF,NIL,OR,PRINT,RERUTN,SUPER,WHILE,
    EOF


}
