package Beings;

import BattleField.Field;

public class Crab extends Creature {
    static int damage = 10;
    static int health = 30;

    public Crab(Field f) {
        super(0, 0, damage, health, false, f, "xiezijing.png");
    }
}
