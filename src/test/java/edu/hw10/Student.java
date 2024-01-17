package edu.hw10;

import edu.hw10.Annotations.Max;
import edu.hw10.Annotations.Min;
import edu.hw10.Annotations.NotNull;

public record Student(@NotNull String name, @Min(0) long id, @Min(17) @Max(150) int age) {
    public static Student create(
        @NotNull String name, @Min(0) long id, @Min(17) @Max(150) int age
    ) {
        return new Student(name, id, age);
    }
}
