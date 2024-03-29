package io.bijide;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedImplementTest {

    ReplacementStrategy advImpl = ReplacementFactory.getReplacement("advance");

    @ParameterizedTest
    @CsvSource({
           "abcd,abcd","aaac,c","abcccbad,abbbad|aaad|d","aabcccbbad,aabbbbad|aaaad|d"
    })
    void simpleTest(String input, String expect) {
        ArrayList output = new ArrayList();
        String[] expectedArray = expect.split("\\|");
        advImpl.getResult(input, output);
        assertArrayEquals(expectedArray, output.toArray(new String[]{}), "The output is not match.");
    }
}