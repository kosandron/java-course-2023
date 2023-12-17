package edu.hw10;

import edu.hw10.Annotations.Max;
import edu.hw10.Annotations.Min;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class RandomObjectGenerator {
    private final static Random RANDOM = new Random();

    public Object nextObject(Class newClass)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if (newClass.isPrimitive()) {
            return getRandomValue(newClass, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Constructor[] constructors = newClass.getConstructors();
        Constructor randomConstructor = constructors[0];
        Class<?>[] parameters = randomConstructor.getParameterTypes();
        var annotations = randomConstructor.getParameterAnnotations();

        if (parameters.length == 0) {
            return randomConstructor.newInstance();
        }

        Object[] randomizedArgs = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            randomizedArgs[i] = randomArgValue(parameters[i], annotations[i]);
        }

        return randomConstructor.newInstance(randomizedArgs);
    }

    public Object nextObject(Class newClass, String factoryMethodName)
        throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = Arrays.stream(newClass.getDeclaredMethods())
            .filter(methode -> methode.getName().equals(factoryMethodName))
            .findFirst()
            .orElseThrow(() -> new NoSuchMethodException("Method was not found!"));

        Class<?>[] parameters = method.getParameterTypes();
        var annotations = method.getParameterAnnotations();
        Object[] args = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            args[i] = randomArgValue(parameters[i], annotations[i]);
        }

        return method.invoke(null, args);
    }

    @SuppressWarnings("ReturnCount")
    private Object randomArgValue(Class<?> newClass, Annotation[] annotations) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (Annotation annotation : annotations) {
            if (annotation instanceof Min minAnnotation) {
                min = minAnnotation.value();
            } else if (annotation instanceof Max maxAnnotation) {
                max = maxAnnotation.value();
            }
        }

        if (newClass.isPrimitive()) {
            return getRandomValue(newClass, min, max);
        }

        if (newClass.equals(String.class)) {
            return "Random string";
        }

        try {
            return nextObject(newClass.getClass());
        } catch (InvocationTargetException e) {
            return null;
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    private Object getRandomValue(Class<?> newClass, int min, int max) {
        Object randomValue = null;
        if (newClass.equals(byte.class)) {
            randomValue =
                (byte) RANDOM.nextInt(Math.max(min, Byte.MIN_VALUE), Math.min(max, Byte.MAX_VALUE));
        } else if (newClass.equals(short.class)) {
            randomValue =
                (short) RANDOM.nextInt(Math.max(Short.MIN_VALUE, min), Math.min(Short.MAX_VALUE, max));
        } else if (newClass.equals(int.class)) {
            randomValue =
                RANDOM.nextInt(Math.max(Integer.MIN_VALUE, min), Math.min(Integer.MAX_VALUE, max));
        } else if (newClass.equals(long.class)) {
            randomValue = RANDOM.nextLong(Math.max(Long.MIN_VALUE, min), Math.min(Long.MAX_VALUE, max));
        } else if (newClass.equals(float.class)) {
            randomValue =
                RANDOM.nextFloat(Math.max(Float.MIN_VALUE, (float) min), Math.min(Float.MAX_VALUE, (float) max));
        } else if (newClass.equals(double.class)) {
            randomValue =
                RANDOM.nextDouble(Math.max(Double.MIN_VALUE, min), Math.min(Double.MAX_VALUE, max));
        } else if (newClass.equals(boolean.class)) {
            randomValue = RANDOM.nextBoolean();
        } else if (newClass.equals(char.class)) {
            randomValue = (char) RANDOM.nextInt(
                Math.max(min, Character.MIN_VALUE),
                Math.min(max, Character.MAX_VALUE)
            );
        }

        return randomValue;
    }
}
