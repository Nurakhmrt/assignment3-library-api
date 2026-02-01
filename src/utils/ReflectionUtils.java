package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class ReflectionUtils {

    private ReflectionUtils() {}

    public static void inspect(Object obj) {
        Class<?> c = obj.getClass();

        System.out.println("Class: " + c.getName());

        System.out.println("Fields:");
        Arrays.stream(c.getDeclaredFields())
                .forEach(f -> System.out.println(" - " + f.getName()));

        System.out.println("Methods:");
        Arrays.stream(c.getDeclaredMethods())
                .forEach(m -> System.out.println(" - " + m.getName()));
    }
}
