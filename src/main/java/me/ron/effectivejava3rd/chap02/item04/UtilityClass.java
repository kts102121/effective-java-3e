package me.ron.effectivejava3rd.chap02.item04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError("Cannot instantiate this class");
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Constructor<UtilityClass> utilityClassConstructor = UtilityClass.class.getDeclaredConstructor();
            utilityClassConstructor.setAccessible(true);
            UtilityClass utilityClass = utilityClassConstructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
