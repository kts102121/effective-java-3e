package me.ron.effectivejava3rd.chap02.item03.publicstaticfield;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    /**
     * A privileged client can invoke the private constructor reflectively with the aid of the
     * AccessibleObject.setAccessible method, If you need to defend this, modify the constructor.
     */
    private Elvis() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Only one instance is allowed");
        }
    }

    public void leaveTheBuilding() {}
}

class Main {
    public static void main(String[] args) {
        // Works fine
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        try {
            // Works too
            Constructor<Elvis> elvisPrivateConstructor = Elvis.class.getDeclaredConstructor();
            elvisPrivateConstructor.setAccessible(true);
            Elvis instance = (Elvis) elvisPrivateConstructor.newInstance();

        } catch (NoSuchMethodException nsme) {
            System.err.println("No such method exception");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | IllegalStateException e) {
            System.err.println(e.getCause().getMessage());
        }
    }
}