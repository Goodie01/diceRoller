package org.example;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random(1L);
        DiceRoll diceRoll = DiceRoll.start()
                .withDiceRolls(3)
                .withDiceSize(6)
                .withBaseAmount(6)
                .withAdvantage();

        System.out.println(diceRoll);

        for (int i = 0; i < 1000; i++) {
            System.out.println(diceRoll.result(random).get());
        }
    }
}
