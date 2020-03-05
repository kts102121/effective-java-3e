package me.ron.effectivejava3rd.chap02.item02.builder;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // required
        private final int servingSize;
        private final int servings;

        // optional
        private int calories     = 0;
        private int fat          = 0;
        private int sodium       = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        /**
         * Like a constructor, a builder can impose invariants on its parameters. The build method can check these invariants.
         * It is critical that they be checked after copying the parameters from the builder to the object, and that they be checked on the object fields rather than the builder fields (Item 39).
         * If any invariants are violated, the build method should throw an IllegalStateException (Item 60). The exception's detail method should indicate which invariant is violated (Item 63).
         *
         * Another way to impose invariants involving multiple parameters is to have setter methods take entire groups of parameters on which some invariant must hold.
         * If the invariant isn't satisfied, the setter method throws an IllegalArgumentException. This has the advantage of detecting the invariant failure as soon as the invalid parameters are passed,
         * instead of waiting for build to be invoked.

         * @return {@code NutritionFacts}
         */
        public NutritionFacts build() {
            if (calories < 0) {
                throw new IllegalArgumentException("Calories should be greater than 0");
            }
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder build) {
        this.servingSize  = build.servingSize;
        this.servings     = build.servings;
        this.calories     = build.calories;
        this.fat          = build.fat;
        this.sodium       = build.sodium;
        this.carbohydrate = build.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
    }
}
