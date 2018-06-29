package com.intrepretter.core;

import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private String source;
    final List<Token> tokens = new ArrayList<>();

    int current,start,line=1;

    public Scanner(String sourceCode) {
        this.source = sourceCode;
    }

    public List<Token> parse() {

        while(!isAtEnd()){
            start = current;
            scanToken();
        }
        return null;
    }

    private void scanToken() {
        char c = advance();
        switch (c){
            case '(':addToken(TokenType.LEFT_PAREN);
        }
    }

    private void addToken(TokenType ttype) {
        addToken(ttype,null);
    }

    private void addToken(TokenType ttype, Object literal) {
    }

    private char advance() {
        current++;
        return source.charAt(current-1);
    }

    private boolean isAtEnd(){
        return source.length() >= current;
    }
}
