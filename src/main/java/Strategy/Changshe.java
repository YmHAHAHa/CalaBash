package Strategy;

import BattleField.Field;
import BattleField.Position;
import Beings.CalaBashBro;
import Beings.Footman;

import java.util.ArrayList;

public class Changshe implements ZhenFa {
    static int[] huluY = {2, 3, 4, 5, 6, 7, 8};
    static int[] yaoguaiY = {2, 3, 4, 5, 6, 7, 8};

    public void applyHulu(Field field) {
        ArrayList<CalaBashBro> hulus = field.allHulu;
        Position[][] ground=field.getGround();
        for (int i = 0; i < 7; ++i) {
            hulus.get(i).setXY(1, huluY[i]);
            ground[huluY[i]][1].setCreature(hulus.get(i));
        }
        field.yeye.setXY(0, 8);
        ground[0][0].setCreature(field.yeye);
    }

    public void applyYaoguai(Field field) {
        ArrayList<Footman> slimes = field.allSlime;
        Position[][] ground=field.getGround();
        for (int i = 0; i < 7; ++i) {
            slimes.get(i).setXY(8, yaoguaiY[i]);
            ground[yaoguaiY[i]][8].setCreature(slimes.get(i));
        }
        field.snake.setXY(9, 4);
        ground[4][9].setCreature(field.snake);
        field.crab.setXY(7, 4);
        ground[4][7].setCreature(field.crab);
    }
}
