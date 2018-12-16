package Beings;

import BattleField.Field;

public class CalaBashBro extends Creature {
    static int[] damages = {10, 10, 10, 10, 10, 10, 10};
    static int[] healths = {30, 30, 30, 30, 30, 30, 30};

    private CalaBashColor color;

    public CalaBashBro(CalaBashColor c, Field f) {
        super(0, 0, damages[c.ordinal()], healths[c.ordinal()],
                f, (c.ordinal() + 1) + ".png");
        this.color = c;
    }
}
