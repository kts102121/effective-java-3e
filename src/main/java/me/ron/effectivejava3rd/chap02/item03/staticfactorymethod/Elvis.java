package me.ron.effectivejava3rd.chap02.item03.staticfactorymethod;

import java.awt.print.Pageable;
import java.io.Serializable;

public class Elvis implements Serializable {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println(this + " leaving the building.");
    }
}

class Main {
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        Elvis elvis2 = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}