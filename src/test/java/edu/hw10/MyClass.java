package edu.hw10;

import edu.hw10.Annotations.Max;
import edu.hw10.Annotations.Min;
import edu.hw10.Annotations.NotNull;

public class MyClass {

    private String key;
    private double value;

    public MyClass(@NotNull String key, @Min(-11) @Max(12) double value) {
        this.key = key;
        this.value = value;
    }

    public static MyClass create(
        @NotNull String name,
        @Min(-11) @Max(12) double value
    ) {
        return new MyClass(name, value);
    }

    public double value() {
        return value;
    }

    public String key() {
        return key;
    }
}
