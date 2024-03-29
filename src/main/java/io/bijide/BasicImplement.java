package io.bijide;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicImplement implements ReplacementStrategy {
    @Override
    public void getResult(String input, ArrayList result) {
        char[] loop = input.toCharArray();
        int size = loop.length;

        System.out.println("input [" + input + "], result [" + Arrays.toString(result.toArray()) + "]");
        for (int outterIndex = 0; outterIndex < size; outterIndex++) {
            char currentChar = loop[outterIndex];
            int matchCount = 0;
            for (int innerIndex = outterIndex; innerIndex < size; innerIndex++) {
                System.out.println("outter index [" + outterIndex + "] , innerIndex [" + innerIndex + "]");
                char innerChar = loop[innerIndex];
                if (currentChar == innerChar) {
                    matchCount++;
                } else {
                    if (matchCount >= 3) {
                        String mergedResult = input.substring(0, outterIndex) + input.substring(innerIndex, loop.length);
                        result.add(mergedResult);
                        System.out.println(mergedResult);
                        getResult(mergedResult, result);
                        return;
                    }
                    break;
                }
                if (innerIndex + 1 == size) {
                    if (result.size()==0){
                        result.add(input);
                    }
                    return;
                }
            }

        }
    }
}
