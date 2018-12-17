package Beings;


import BattleField.Field;

public class Footman extends Creature {
    static int damage = 10;
    static int health = 30;

    public Footman(Field f) {
        super(0, 0, damage, health, false, f, "hamajing.png");
    }
}
