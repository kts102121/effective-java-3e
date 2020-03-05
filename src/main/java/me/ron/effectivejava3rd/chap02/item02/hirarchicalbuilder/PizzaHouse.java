package me.ron.effectivejava3rd.chap02.item02.hirarchicalbuilder;

import static me.ron.effectivejava3rd.chap02.item02.hirarchicalbuilder.NyPizza.Size.SMALL;
import static me.ron.effectivejava3rd.chap02.item02.hirarchicalbuilder.Pizza.Topping.*;

public class PizzaHouse {
    public static void main(String[] args) {
        Pizza nyPizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        Pizza Calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

        try {
            nyPizza.toppings.add(MUSHROOM);
        } catch (UnsupportedOperationException uoe) {
            System.err.println("You cannot add toppings after order is accepted!");
        }
    }
}
