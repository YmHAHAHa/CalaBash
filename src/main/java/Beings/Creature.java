package Beings;

import BattleField.Field;
import BattleField.IVmanager;
import javafx.application.Platform;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class Creature implements Runnable {

    private int x, y, indexIV, indexRun;
    private int damage, health;
    private Image image;
    private Field field;
    public boolean isGood;
    public boolean isGo;

    public Creature(int x, int y, int d, int h, boolean ig, Field f, String imagepath) {
        this.x = x;
        this.y = y;
        this.indexIV = -1;
        this.indexRun = -1;
        this.field = f;
        this.damage = d;
        this.health = h;
        this.isGood = ig;
        this.isGo = true;
        this.image = new Image(imagepath);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setHealth(int i) {
        health = i;
    }

    public int getX() {
        return this.x;
    }

    public void setIndexIV(int indexIV) {
        this.indexIV = indexIV;
    }

    public void setIndexRun(int indexRun) {
        this.indexRun = indexRun;
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

    public void run() {
        while (!Thread.interrupted()) {
            if (!isGo) return;

            Random rand = new Random();

            if (!isAlive()) {
                field.allView.get(indexIV).iv.setImage(new Image("die.png"));
                isGo = false;
            } else {
                int minlength = 21;
                Creature minEnemy = null;
                ArrayList<Creature> enemyList = isGood ? field.allBad : field.allGood;
                for (int i = 0; i < enemyList.size(); ++i) {
                    if (!enemyList.get(i).isAlive()) continue;
                    int tmplength = Math.abs(enemyList.get(i).x - x) + Math.abs(enemyList.get(i).y - y);
                    if (tmplength < minlength) {
                        minlength = tmplength;
                        minEnemy = enemyList.get(i);
                    }
                }//get nearest alive enemy

                if (minEnemy == null) {
                    isGo = false;
                } else {
                    if (minlength == 1) {
                        field.Fight(this, minEnemy, rand);
                    } else {
                        if (field.Move(this, minEnemy, rand)) {
                            field.allView.get(indexIV).x = x;
                            field.allView.get(indexIV).y = y;
                        }
                    }
                }
            }

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    field.drawOneCreature(indexIV);
                }
            });

            try {
                if (isGo) {
                    Thread.sleep(rand.nextInt(500) + 300);
                } else {
                    field.stopOneRun(indexRun);
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
