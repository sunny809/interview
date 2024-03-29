package io.bijide;

import java.util.HashMap;
import java.util.Map;

public class ReplacementFactory {

    private static final Map<String, ReplacementStrategy> map = new HashMap<>();
    static {
        map.put("basic", new BasicImplement());
        map.put("advance", new AdvancedImplement());
    }
    public static ReplacementStrategy getReplacement(String type) {
        return map.get(type);
    }
}
