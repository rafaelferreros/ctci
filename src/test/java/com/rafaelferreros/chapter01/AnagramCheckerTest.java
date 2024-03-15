package com.rafaelferreros.chapter01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AnagramCheckerTest {

    private AnagramCheckerOrderedLists anagramCheckerOrderedLists;

    private AnagramCheckerMap anagramCheckerMap;

    @BeforeMethod
    public void setUp() {
        anagramCheckerOrderedLists = new AnagramCheckerOrderedLists();
        anagramCheckerMap = new AnagramCheckerMap();
    }

    @Test(dataProvider = "anagramProvider")
    public void testIsAnagram(String textA, String textB, boolean expected) {
        assertEquals(anagramCheckerOrderedLists.isAnagram(textA, textB), expected);
    }

    @Test(dataProvider = "anagramProvider")
    public void testIsAnagramUsingCheckerMap(String textA, String textB, boolean expected) {
        assertEquals(anagramCheckerMap.isAnagram(textA, textB), expected);
    }

    @DataProvider()
    private Object[][] anagramProvider() {
        return new Object[][] {
                {"a", "a", true},
                {"ab", "ab", true},
                {"abc", "ab", false},
                {"ab", "ba", true},
                {"abd", "bad", true},
                {"abc", "bad", false},
                {"aac", "aac", true},
                {"abcdefghijklmnopqrstuvwxyz ", " zyxwvutsrqponmlkjihgfedcba", true},
                {"abcdefghijklmnopqrstuvwxyz ", " ayxwvutsrqponmlkjihgfedcba", false},
                {"this is a long", "long a this is", true},
                {"ABC", "abc", false},
                {"aa", "aa", true}
        };
    }
}