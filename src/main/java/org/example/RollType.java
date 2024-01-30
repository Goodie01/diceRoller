package org.example;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;

public enum RollType {
    NORMAL("normal roll", IntSupplier::getAsInt),
    ADVANTAGE("with Advantage", rollSupplier -> Math.max(rollSupplier.getAsInt(), rollSupplier.getAsInt())),
    DISADVANTAGE("with disadvantage", rollSupplier -> Math.min(rollSupplier.getAsInt(), rollSupplier.getAsInt()));

    private final String description;
    private final Roller roller;

    RollType(String description, Roller roller) {
        this.description = description;
        this.roller = roller;
    }

    private BiFunction<Random, Integer, Integer> method;

    public int roll(final Random random, final int diceSize) {
        return roller.calculate(() -> (1 + random.nextInt(diceSize)));
    }

    public String getDescription() {
        return description;
    }

    private interface Roller {
        int calculate(IntSupplier rollSupplier);
    }
}