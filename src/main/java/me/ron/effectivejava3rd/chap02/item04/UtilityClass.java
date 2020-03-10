package me.ron.effectivejava3rd.chap02.item04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class UtilityClass {
    public static double sum(double left, double right) {
        return left + right;
    }

    public static double sub(double left, double right) {
        return left - right;
    }

    public static double multiply(double left, double right) {
        return left * right;
    }

    public static double divide(double left, double right) {
        return left / right;
    }

    private UtilityClass() {
        throw new AssertionError("You are not allowed to instantiate utility classes");
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Constructor<UtilityClass> utilityClassConstructor = UtilityClass.class.getDeclaredConstructor();
            utilityClassConstructor.setAccessible(true);
            UtilityClass utilityClass = utilityClassConstructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(e.getCause().getMessage());
        }

        System.out.println(UtilityClass.divide(10, 10));
    }
}
