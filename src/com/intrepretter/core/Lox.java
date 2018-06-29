package com.intrepretter.core;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
    public static void main(String[] args) {
        if(args.length>1)
            System.out.println("Usage ::lox file");

        if(args.length>0) runFile(args[0]);


        if(args.length==0) runPrompt();

    }

    private static void runFile(String filePath) {
        try {
            String source = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        run(filePath);
    }

    private static void runPrompt() {
        for(;;){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            run(s);
        }
    }

    private static void run(String sourceCode) {
        System.out.println("Running "+sourceCode);

        Scanner sc = new Scanner(sourceCode);
        List<Token> tokens = sc.parse();
        tokens.stream().forEach(System.out::println);

    }
}
