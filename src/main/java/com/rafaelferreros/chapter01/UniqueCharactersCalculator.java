package com.rafaelferreros.chapter01;

import java.util.Arrays;

/* Implement an Algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class UniqueCharactersCalculator {

    public boolean hasOnlyUniqueCharactersWithDistinct(String text) {
        final String[] characters = text.split("");
        final long newCount = Arrays.stream(characters)
                .distinct()
                .count();

        return newCount == characters.length;
    }

    public boolean hasOnlyUniqueCharactersIterative(String text) {
        for (int i =0; i < text.length() - 1; i++) {
            char value = text.charAt(i);
            if (containsChar(value, text.substring(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean containsChar(char charToCheck, String text) {
        return text.contains(String.valueOf(charToCheck));
    }





}
