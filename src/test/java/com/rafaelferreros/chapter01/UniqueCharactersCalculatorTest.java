package com.rafaelferreros.chapter01;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UniqueCharactersCalculatorTest {

    UniqueCharactersCalculator uniqueCharactersCalculator;

    @BeforeClass
    public void setUp() {
        uniqueCharactersCalculator = new UniqueCharactersCalculator();
    }

    @Test(dataProvider = "textsDataProvider")
    public void testHasOnlyUniqueCharactersWithDistinct(String testText, boolean expectedResult) {
        assertEquals(uniqueCharactersCalculator.hasOnlyUniqueCharactersWithDistinct(testText), expectedResult);
    }

    @Test(dataProvider = "textsDataProvider")
    public void testHasOnlyUniqueCharactersIterative(String testText, boolean expectedResult) {
        assertEquals(uniqueCharactersCalculator.hasOnlyUniqueCharactersIterative(testText), expectedResult);
    }

    @DataProvider()
    private Object[][] textsDataProvider() {
        return new Object[][] {
                {"a", true},
                {"ab", true},
                {"this is a normal text", false},
                {"  ", false},
                {"abcdefghijklmnopqrstuvwxyz ", true},
                {"aba", false},
                {"abb", false},
                {"aa", false}
        };
    }
}