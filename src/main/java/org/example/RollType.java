package org.example;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;

public enum RollType {
    NORMAL(IntSupplier::getAsInt),
    ADVANTAGE(rollSupplier -> Math.max(rollSupplier.getAsInt(), rollSupplier.getAsInt())),
    DISADVANTAGE(rollSupplier -> Math.min(rollSupplier.getAsInt(), rollSupplier.getAsInt()));

    private final Roller roller;

    RollType(Roller roller) {
        this.roller = roller;
    }

    private BiFunction<Random, Integer, Integer> method;

    public int roll(final Random random, final int diceSize) {
        return roller.calculate(() -> (1 + random.nextInt(diceSize)));
    }

    private interface Roller {
        int calculate(IntSupplier rollSupplier);
    }
}