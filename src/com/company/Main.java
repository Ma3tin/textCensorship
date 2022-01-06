package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(blur(badWords[1]));
        File file = new File("src/com/company/input.txt");
        init(file);
    }

    public static String[] badWords = new String[] {
            "debil",
            "prdel",
            "hovno",
            "penis",
            "píča",
            "čurák",
            "hovado"
    };

    public static String blur(String word) {
        String output = "";
        for (int i = 0; i < word.length(); i++) {
            output += "*";
        }
        return output;
    }

    public static void init(File input) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line = br.readLine();
            StringBuilder endLine = new StringBuilder();
            System.out.println(line);
            String newLine = "";
            String[] lineWords = line.split(" ");
            for (int i = 0; i < badWords.length; i++) {
                int fromIndex = 0;
                System.out.println(badWords[i]);
                while ((fromIndex = line.indexOf(badWords[i], fromIndex)) >= 0) {
                    String slovo = line.substring(fromIndex, line.indexOf(" ", fromIndex));
                    line = line.replace(slovo, blur(slovo));
                    System.out.println(line);
                }
            }
            System.out.println(endLine);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
