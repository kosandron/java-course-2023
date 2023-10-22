package edu.hw3;

import java.util.HashMap;
import java.util.List;

public final class Task3 {
    private Task3() {
    }

    public static HashMap<String, Integer> freqDict(List<String> stringList) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < stringList.size(); i++) {
            if (result.containsKey(stringList.get(i))) {
                result.put(stringList.get(i), result.get(stringList.get(i)) + 1);
            } else {
                result.put(stringList.get(i), 1);
            }
        }
        return result;
    }
}
