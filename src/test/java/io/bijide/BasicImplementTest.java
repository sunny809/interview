package io.bijide;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BasicImplementTest {

    ReplacementStrategy basicImpl = ReplacementFactory.getReplacement("basic");

    @ParameterizedTest
    @CsvSource({
            "abc,abc",
            "aaabb,bb",
            "aabcccbbad,aabbbad|aaad|d",
            "bbbcccdddf,cccdddf|dddf|f",
            "ggffcccfffdd,ggfffffdd|ggdd",
            "abcdefg,abcdefg",
            "bbcccbbaabbab,bbbbaabbab|aabbab"
    })
    void simpleTest(String input, String expect) {
        ArrayList output = new ArrayList();
        String[] expectedArray = expect.split("\\|");
        basicImpl.getResult(input, output);
        assertArrayEquals(expectedArray, output.toArray(new String[]{}), "The output is not match.");
    }

}