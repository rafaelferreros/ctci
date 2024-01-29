package com.rafaelferreros.chapter01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Given two strings, write a method to decide if one is a permutation of the other.
 */
public class PermutationCheckCalculator {

    public boolean isAnagram(String textA, String textB) {
        if (textA.equals(textB)) {
            return true;
        }
        if (textA.length() != textB.length()) {
            return false;
        }

        return hasSameCharacters(textA, textB);
    }

    private boolean hasSameCharacters(String textA, String textB) {
        List<String> listA = Arrays.stream(textA.split(""))
                .sorted()
                .collect(Collectors.toList());

        List<String> listB = Arrays.stream(textB.split(""))
                .sorted()
                .collect(Collectors.toList());
        return listA.equals(listB);
    }
}
