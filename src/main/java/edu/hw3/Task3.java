package edu.hw3;

import java.util.HashMap;
import java.util.List;

public final class Task3 {
    private Task3() {
    }

    public static <T> HashMap<T, Integer> freqDict(List<T> list) {
        HashMap<T, Integer> result = new HashMap<>();
        for (T t : list) {
            if (result.containsKey(t)) {
                result.put(t, result.get(t) + 1);
            } else {
                result.put(t, 1);
            }
        }
        return result;
    }
}
