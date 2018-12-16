package BattleField;

import Beings.CalaBashBro;
import Beings.CalaBashColor;
import gui.LayoutControl;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Field {
    private final int COL = 10;
    private final int ROW = 10;
    public Position[][] ground;
    private LayoutControl layoutControl;

    public ArrayList<CalaBashBro> allHulu;
    public ArrayList<ImageView> allView;

    public Field(LayoutControl lc) {
        this.layoutControl = lc;
        layoutControl.setField(this);
        initAll();
    }

    private void initAll() {
        this.ground = new Position[ROW][COL];
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j) {
                ground[i][j] = new Position(i, j);
            }
        allView = new ArrayList<ImageView>();
        allHulu = new ArrayList<CalaBashBro>();
        allHulu.add(new CalaBashBro(CalaBashColor.RED, this));
        allHulu.add(new CalaBashBro(CalaBashColor.ORANGE, this));
        allHulu.add(new CalaBashBro(CalaBashColor.YELLOW, this));
        allHulu.add(new CalaBashBro(CalaBashColor.GREEN, this));
        allHulu.add(new CalaBashBro(CalaBashColor.BLUE, this));
        allHulu.add(new CalaBashBro(CalaBashColor.CYAN, this));
        allHulu.add(new CalaBashBro(CalaBashColor.PURPLE, this));
        setHuluView();
    }

    private void setHuluView() {

    }

    public void testHULU() {
        for (int i = 0; i < 7; ++i) {
            ImageView iv = new ImageView();
            iv.setImage(allHulu.get(i).getImage());
            iv.setFitHeight(70);
            iv.setFitWidth(70);
            layoutControl.setIV(iv, 1, i + 3);
        }
    }
}
