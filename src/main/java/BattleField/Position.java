package BattleField;

import Beings.Creature;

public class Position {
    private int x, y;
    Creature creature;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        creature = null;
    }

    public void setCreature(Creature c) {
        if (this.creature != null) {
            System.err.println("Error at Position(" + this.x + "," + this.y + ")");
            return;
        }
        this.creature = c;
    }

    public Creature getCreature() {
        return this.creature;
    }

    public void init() {
        this.creature = null;
    }

    public boolean isEmpty() {
        return this.creature == null;
    }
}
