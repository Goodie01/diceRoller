package org.example;

import java.util.Random;
import java.util.stream.IntStream;

public class DiceRoll {
    private final int baseAmount;
    private final int diceRolls;
    private final int diceSize;
    private final RollType rollType;

    public DiceRoll(
            final int baseAmount,
            final int diceRolls,
            final int diceSize,
            final RollType rollType) {
        this.baseAmount = baseAmount;
        this.diceRolls = diceRolls;
        this.diceSize = diceSize;
        this.rollType = rollType;
    }

    public static DiceRoll of(final int diceRolls,
            final int diceSize) {
        return new DiceRoll(0, diceRolls, diceSize, RollType.NORMAL);
    }

    public static DiceRoll of(final int diceRolls, final int diceSize, final int baseAmount) {
        return new DiceRoll(baseAmount, diceRolls, diceSize, RollType.NORMAL);
    }

    public int getBaseAmount() {
        return baseAmount;
    }

    public int getDiceRolls() {
        return diceRolls;
    }

    public int getDiceSize() {
        return diceSize;
    }

    public RollType getRollType() {
        return rollType;
    }

    public DiceRoll withBaseAmount(final int baseAmount) {
        return new DiceRoll(baseAmount, diceRolls, diceSize, rollType);
    }

    public DiceRoll withDiceRolls(final int diceRolls) {
        return new DiceRoll(baseAmount, diceRolls, diceSize, rollType);
    }

    public DiceRoll withDiceSize(final int diceSize) {
        return new DiceRoll(baseAmount, diceRolls, diceSize, rollType);
    }

    public DiceRoll withAdvantage() {
        return new DiceRoll(baseAmount, diceRolls, diceSize, RollType.ADVANTAGE);
    }

    public DiceRoll withDisadvantage() {
        return new DiceRoll(baseAmount, diceRolls, diceSize, RollType.DISADVANTAGE);
    }

    public DiceRoll withNormalRoll() {
        return new DiceRoll(baseAmount, diceRolls, diceSize, RollType.NORMAL);
    }

    @Override
    public String toString() {
        return baseAmount + "+" + diceRolls + "D" + diceSize;
    }

    public int roll(final Random random) {
        return baseAmount + IntStream.rangeClosed(1, diceRolls).map(i -> rollType.roll(random, diceSize)).sum();
    }
}