package me.ron.effectivejava3rd.chap02.item03.enumtype;

public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {}
}

class Main {
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}