package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharacterFiles {
    public static void main(String[] args) {
        String file = "C:\\Users\\shagi\\Downloads\\24_demo.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int oneCharacter;
            int maxLen= 0;
            int currentLen = 0;
            boolean notSeq = false;

            while ((oneCharacter = reader.read()) != -1) {
                char currentChar = (char) oneCharacter;

                if (currentChar == 'X') {
                    if (notSeq) {
                        currentLen++;
                    } else {
                        notSeq = true;
                        currentLen = 1;
                    }
                } else {
                    notSeq = false;
                    currentLen = 0;
                }

                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
            }

            reader.close();

            System.out.println("Длина самой длинной последовательности символов 'X' в файле: " + maxLen);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
