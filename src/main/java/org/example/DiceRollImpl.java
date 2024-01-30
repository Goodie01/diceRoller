package org.example;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author thomas.goodwin
 */
public class DiceRollImpl implements DiceRoll{
    private final int baseAmount;
    private final int diceRolls;
    private final int diceSize;
    private final int rollType;

    public DiceRollImpl(int baseAmount, int diceRolls, int diceSize, int rollType) {
        this.baseAmount = baseAmount;
        this.diceRolls = diceRolls;
        this.diceSize = diceSize;
        this.rollType = rollType;
    }

    @Override
    public DiceRoll withBaseAmount(int baseAmount) {
        return new DiceRollImpl(baseAmount, diceRolls, diceSize, rollType);
    }

    @Override
    public DiceRoll withDiceRolls(int diceRolls) {
        return new DiceRollImpl(baseAmount, diceRolls, diceSize, rollType);
    }

    @Override
    public DiceRoll withDiceSize(int diceSize) {
        return new DiceRollImpl(baseAmount, diceRolls, diceSize, rollType);
    }

    @Override
    public DiceRoll withAdvantage() {
        return new DiceRollImpl(baseAmount, diceRolls, diceSize, rollType + 1);
    }

    @Override
    public DiceRoll withDisadvantage() {
        return new DiceRollImpl(baseAmount, diceRolls, diceSize, rollType - 1);
    }

    @Override
    public DiceRollResult result(Random random) {
        int result = baseAmount + IntStream.rangeClosed(1, diceRolls).map(i -> getRollType().roll(random, diceSize)).sum();
        return new DiceRollResult(result);
    }

    private RollType getRollType() {
        if(rollType == 0) {
            return RollType.NORMAL;
        } else if(rollType < 0) {
            return RollType.DISADVANTAGE;
        } else {
            return RollType.ADVANTAGE;
        }
    }

    @Override
    public String toString() {
        RollType calculatedRollType = getRollType();

        if(calculatedRollType == RollType.NORMAL) {
            return baseAmount + "+" + diceRolls + "D" + diceSize;
        } else {
            return baseAmount + "+" + diceRolls + "D" + diceSize + " (" + calculatedRollType.getDescription() + ")";
        }
    }
}
