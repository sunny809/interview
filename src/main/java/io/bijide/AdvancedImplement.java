package io.bijide;

import java.util.ArrayList;
import java.util.Arrays;

public class AdvancedImplement implements ReplacementStrategy {

    String[] dictionary = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z"};

    @Override
    public void getResult(String input, ArrayList result) {
        char[] loop = input.toCharArray();
        int size = loop.length;
//        if (size == 1) {
//            return;
//        }

        System.out.println("input [" + input + "], result [" + Arrays.toString(result.toArray()) + "]");
        for (int outterIndex = 0; outterIndex < size; outterIndex++) {
            char currentChar = loop[outterIndex];
            int matchCount = 0;
            for (int innerIndex = outterIndex; innerIndex < size; innerIndex++) {
                System.out.println("outter index [" + outterIndex + "] , innerIndex [" + innerIndex + "] match count [" + matchCount+ "]");
                char innerChar = loop[innerIndex];
                if (currentChar == innerChar) {
                    matchCount++;
                } else {
                    if (matchCount >= 3) {
                        String mergedResult = input.substring(0, outterIndex) + lookupForReplacement(String.valueOf(currentChar))+ input.substring(innerIndex, loop.length);
                        result.add(mergedResult);
                        System.out.println(mergedResult);
                        getResult(mergedResult, result);
                        return;
                    }
                    break;
                }
                if (innerIndex + 1 == size) {
                    if (result.size() == 0) {
                        result.add(input);
                    }
                    return;
                }
            }

        }
    }

    String lookupForReplacement(String input){
        for (int index = 0; index<dictionary.length;index++){
            String currentChar = dictionary[index];
            if (currentChar.equals(input)){
                if (index==0){
                    return "";
                }
                return dictionary[index-1];
            }
        }
        return "";
    }
}
