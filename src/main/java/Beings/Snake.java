package Beings;

import BattleField.Field;

public class Snake extends Creature {
    static int damage = 10;
    static int health = 30;

    public Snake(Field f) {
        super(0, 0, damage, health, false, f, "shejing.png");
    }
}
