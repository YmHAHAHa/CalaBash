package Beings;

import BattleField.Field;
import javafx.scene.image.Image;

import java.net.URL;

public class Creature {

    private int x, y;
    private int damage, health;
    private Image image;
    private Field field;

    public Creature(int x, int y, int d, int h, Field f, String imagepath) {
        this.x = x;
        this.y = y;
        this.field = f;
        this.damage = d;
        this.health = h;
        this.image = new Image(imagepath);
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }
}
