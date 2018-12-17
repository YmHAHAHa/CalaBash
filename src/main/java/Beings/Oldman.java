package Beings;

import BattleField.Field;

public class Oldman extends Creature {
    static int damage = 10;
    static int health = 30;

    public Oldman(Field f) {
        super(0, 0, damage, health, true, f, "yeye.png");
    }
}
