package com.example.wordcounter;

public class WordCounter {
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split(" ");
        return words.length;
    }
}
