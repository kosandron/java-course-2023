package edu.hw10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GeneratorTests {
    @Test
    @DisplayName("Primitives create")
    void primitiveTypesCreateTest() {
        var generator = new RandomObjectGenerator();

        assertDoesNotThrow(() ->  (boolean) generator.nextObject(boolean.class));
        assertDoesNotThrow(() ->  (char) generator.nextObject(char.class));
        assertDoesNotThrow(() -> (int) generator.nextObject(int.class));
        assertDoesNotThrow(() ->  (long) generator.nextObject(long.class));
        assertDoesNotThrow(() ->  (float) generator.nextObject(float.class));
        assertDoesNotThrow(() ->  (double) generator.nextObject(double.class));
    }

    @Test
    @DisplayName("Record create")
    void recordCreateTest()
        throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        var generator = new RandomObjectGenerator();

        Student createdByConstructorClass = (Student) generator.nextObject(Student.class);
        Student createdByMethodClass = (Student) generator.nextObject(Student.class, "create");

        assertThat(createdByConstructorClass.name()).isNotNull();
        assertThat(createdByConstructorClass.age()).isBetween(17, 150);

        assertThat(createdByMethodClass.name()).isNotNull();
        assertThat(createdByMethodClass.age()).isBetween(17, 150);
    }

    @Test
    @DisplayName("Class create")
    void pojoCreateTest()
        throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        var generator = new RandomObjectGenerator();

        MyClass createdByConstructorClass = (MyClass) generator.nextObject(MyClass.class);
        MyClass createdByMethodClass = (MyClass) generator.nextObject(MyClass.class, "create");

        assertThat(createdByConstructorClass.key()).isNotNull();
        assertThat(createdByConstructorClass.value()).isBetween(-11d, 12d);

        assertThat(createdByMethodClass.key()).isNotNull();
        assertThat(createdByMethodClass.value()).isBetween(-11d, 12d);
    }
}
