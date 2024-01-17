package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Tests {
    @Test
    @DisplayName("ByteBuddy class creation. Redefine toString()")
    public void byteBuddyClassCreation() throws Exception {
        String newString = "Hello, ByteBuddy!";

        Class<?> testClass = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value(newString))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        assertThat(testClass.getDeclaredConstructor().newInstance().toString()).isEqualTo(newString);
    }
}
