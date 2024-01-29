package com.rafaelferreros.chapter01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PermutationCheckCalculatorTest {

    PermutationCheckCalculator permutationCheckCalculator;

    @BeforeMethod
    public void setUp() {
        permutationCheckCalculator = new PermutationCheckCalculator();
    }

    @Test(dataProvider = "anagramProvider")
    public void testIsAnagram(String textA, String textB, boolean expected) {
        assertEquals(permutationCheckCalculator.isAnagram(textA, textB), expected);
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