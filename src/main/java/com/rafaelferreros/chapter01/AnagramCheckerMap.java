package com.rafaelferreros.chapter01;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramCheckerMap implements AnagramChecker {
    @Override
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

        Map<String, Long> charactersCountA = Arrays.stream(textA.split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Map<String, Long> charactersCountB = Arrays.stream(textB.split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return charactersCountA.equals(charactersCountB);
    }
}
