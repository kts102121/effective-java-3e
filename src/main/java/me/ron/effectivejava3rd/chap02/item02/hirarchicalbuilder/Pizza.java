package me.ron.effectivejava3rd.chap02.item02.hirarchicalbuilder;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // Although Set is final, we can still add toppings here.
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Child class must override this method and return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        // toppings = builder.toppings.clone();

        // Making the toppings list as immutable prevents adding toppings
        toppings = Collections.unmodifiableSet(builder.toppings);
    }
}
