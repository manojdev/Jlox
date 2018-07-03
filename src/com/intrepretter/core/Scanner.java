package com.intrepretter.core;

import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private String source;
     static List<Token> tokens = new ArrayList<>();

    int current=0,start=0,line=1;

    public Scanner(String sourceCode) {
        this.source = sourceCode;
    }

    public List<Token> scanTokens() {

        while(!isAtEnd()){
            start = current;
            scanToken();
        }
        return tokens;
    }

    /*
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
     */
    private void scanToken() {
        char c = advance();
        switch (c){
            case '(':addToken(TokenType.LEFT_PAREN);break;
            case ')':addToken(TokenType.RIGHT_PAREN);break;
            case '[':addToken(TokenType.LEFT_BRACE);break;
            case ']':addToken(TokenType.RIGHT_BRACE);break;
            case ',':addToken(TokenType.COMMA);break;
            case '.':addToken(TokenType.DOT);break;
            case '-':addToken(TokenType.MINUS);break;
            case '+':addToken(TokenType.PLUS);break;
            case ';':addToken(TokenType.SEMICOLON);break;
            case '/':{

                if(peek()=='/')


                addToken(TokenType.SLASH);break;
            }
            case '*':addToken(TokenType.STAR);break;
            case '!':{
                addToken(match('=')?TokenType.BANG_EQUAL:TokenType.BANG);
            }
            case'=':addToken(match('=')?TokenType.EQUAL_EQUAL:TokenType.EQUAL);
            case '<':addToken(match('=')?TokenType.LESSER_EQUAL:TokenType.LESSER);break;
            case '>':addToken(match('=')?TokenType.GREATER_EQUAL:TokenType.GREATER);break;
            default:
                Lox.error(line,"Unexpected Character ::"+line);


        }
    }

    private boolean match(char c) {
        if(!isAtEnd())return false;
        return source.charAt(current) == c;
    }

    private void addToken(TokenType ttype) {
        addToken(ttype,null);
    }



    private void addToken(TokenType ttype, Object literal) {
        String text = source.substring(start,current);
        tokens.add(new Token(ttype,text,literal,line));
    }

    private char advance() {
        current++;
        return source.charAt(current-1);
    }

    private char peek(){
        if(!isAtEnd()) return source.charAt(current);
        return '\0';
    }

    private boolean isAtEnd(){
        return current>=source.length();
    }
}
