package org.example;

import java.util.Random;
import java.util.stream.IntStream;

public interface DiceRoll {
    public static DiceRoll start() {
        return new DiceRollImpl( 0, 1, 20, 0);
    }

    public DiceRoll withBaseAmount(final int baseAmount);

    public DiceRoll withDiceRolls(final int diceRolls);
    public DiceRoll withDiceSize(final int diceSize);

    public DiceRoll withAdvantage();

    public DiceRoll withDisadvantage();

    DiceRollResult result(Random random);
}