package org.example;

/**
 * @author thomas.goodwin
 */
public class DiceRollResult {
    private final int amount;

    public DiceRollResult(int amount) {
        this.amount = amount;
    }

    public int get() {
        return amount;
    }

    public boolean difficultyClass(final int dc) {
        return amount < dc;
    }
}
