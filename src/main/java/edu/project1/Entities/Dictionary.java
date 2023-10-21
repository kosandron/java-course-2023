package edu.project1.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class Dictionary {
    private Dictionary() { }

    private static Map<Integer, List<String>> wordsBySize = new HashMap<>() { };
    private static Random random = new Random();

    public static String getRandomWordBySize(Integer size) {
        if (size <= 1) {
            throw new IllegalArgumentException("To short word size!");
        }

        if (wordsBySize.containsKey(size)) {
            return wordsBySize.get(size).get(random.nextInt() % wordsBySize.get(size).size());
        } else {
            throw new IllegalArgumentException("No words with this size!");
        }
    }

    public static boolean consistWordBySize(Integer size) {
        return wordsBySize.containsKey(size);
    }

    public static void addWord(String word) {
        Integer size = word.length();
        if (wordsBySize.containsKey(size) && !wordsBySize.get(size).contains(word)) {
            wordsBySize.get(size).add(word);
        } else {
            wordsBySize.put(size, new ArrayList<>(Arrays.asList(new String[] {word})));
        }
    }
}
