package BattleField;

import Beings.*;
import Strategy.ZhanfaManager;
import gui.LayoutControl;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Field {
    private final int COL = 10;
    private final int ROW = 10;
    private Position[][] ground;
    private ZhanfaManager zfm;
    private LayoutControl layoutControl;

    public ArrayList<IVmanager> allView;
    public ArrayList<CalaBashBro> allHulu;
    private ArrayList<Thread> allThread;

    public Oldman yeye;
    public Snake snake;
    public Crab crab;
    public ArrayList<Footman> allSlime;

    public ArrayList<Creature> allGood;
    public ArrayList<Creature> allBad;

    public boolean onBattle = false;
    public boolean onReplay = false;

    public Field(LayoutControl lc) {
        this.layoutControl = lc;
        zfm = new ZhanfaManager(this);
        layoutControl.setField(this);
    }

    public synchronized Position[][] getGround() {
        return ground;
    }

    private void initAllView() {
        this.ground = new Position[ROW][COL];
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j) {
                ground[i][j] = new Position(i, j);
            }
        allView = new ArrayList<>();
        allHulu = new ArrayList<>();
        allSlime = new ArrayList<>();
        allThread = new ArrayList<>();
        allGood = new ArrayList<>();
        allBad = new ArrayList<>();

        allHulu.add(new CalaBashBro(CalaBashColor.RED, this));
        allHulu.add(new CalaBashBro(CalaBashColor.ORANGE, this));
        allHulu.add(new CalaBashBro(CalaBashColor.YELLOW, this));
        allHulu.add(new CalaBashBro(CalaBashColor.GREEN, this));
        allHulu.add(new CalaBashBro(CalaBashColor.BLUE, this));
        allHulu.add(new CalaBashBro(CalaBashColor.CYAN, this));
        allHulu.add(new CalaBashBro(CalaBashColor.PURPLE, this));
        yeye = new Oldman(this);
        allGood.addAll(allHulu);
        allGood.add(yeye);

        snake = new Snake(this);
        crab = new Crab(this);
        for (int i = 0; i < 7; ++i) {
            allSlime.add(new Footman(this));
        }
        allBad.addAll(allSlime);
        allBad.add(snake);
        allBad.add(crab);

        zfm.apply();
        setAllImageView();
    }

    private void setAllImageView() {
        for (int i = 0; i < 7; ++i) {
            CalaBashBro tmp = allHulu.get(i);
            tmp.setIndexIV(i);
            allView.add(new IVmanager(tmp.getX(), tmp.getY(), tmp.getImage()));
        }
        yeye.setIndexIV(7);
        allView.add(new IVmanager(yeye.getX(), yeye.getY(), yeye.getImage()));
        snake.setIndexIV(8);
        allView.add(new IVmanager(snake.getX(), snake.getY(), snake.getImage()));
        crab.setIndexIV(9);
        allView.add(new IVmanager(crab.getX(), crab.getY(), crab.getImage()));
        for (int i = 0; i < 7; ++i) {
            Footman tmp = allSlime.get(i);
            tmp.setIndexIV(10 + i);
            allView.add(new IVmanager(tmp.getX(), tmp.getY(), tmp.getImage()));
        }
    }

    private void setAllRun() {
        yeye.setIndexRun(0);
        this.allThread.add(new Thread(yeye));
        snake.setIndexRun(1);
        this.allThread.add(new Thread(snake));
        crab.setIndexRun(2);
        this.allThread.add(new Thread(crab));
        for (int i = 0; i < 7; ++i) {
            allHulu.get(i).setIndexRun(3 + 2 * i);
            this.allThread.add(new Thread(allHulu.get(i)));
            allSlime.get(i).setIndexRun(4 + 2 * i);
            this.allThread.add(new Thread((allSlime.get(i))));
        }
    }

    public void startBattle() {
        initAllView();
        layoutControl.paintAllView();
        onBattle = true;
        setAllRun();
        for (Thread t : allThread)
            t.start();
    }

    public void rePlay(File file) {

    }

    public void drawOneCreature(int i) {
        layoutControl.paintOne(i);
    }

    public void stopOneRun(int i) {
        allThread.get(i).interrupt();
    }

    public synchronized void Fight(Creature c1, Creature c2, Random rand) {
        if (!c1.isAlive() || !c2.isAlive()) return;
        int tmp = rand.nextInt(2);
        if (tmp == 0) {
            c1.setHealth(0);
            ground[c1.getX()][c1.getY()].init();
        } else {
            c2.setHealth(0);
            ground[c2.getX()][c2.getY()].init();
        }
    }

    public synchronized boolean Move(Creature c1, Creature c2, Random rand) {
        int tmp = rand.nextInt(5);
        if (tmp == 0) return false;
        int dx = c2.getX() - c1.getX(), dy = c2.getY() - c1.getY();
        int mx = (dx == 0) ? 0 : dx / Math.abs(dx), my = (dy == 0) ? 0 : dy / Math.abs(dy);
        if (mx != 0 && ground[c1.getX() + mx][c1.getY()].isEmpty()) {
            ground[c1.getX()][c1.getY()].init();
            ground[c1.getX() + mx][c1.getY()].setCreature(c1);
            c1.setXY(c1.getX() + mx, c1.getY());
            return true;
        } else if (my != 0 && ground[c1.getX()][c1.getY() + my].isEmpty()) {
            ground[c1.getX()][c1.getY()].init();
            ground[c1.getX()][c1.getY() + my].setCreature(c1);
            c1.setXY(c1.getX(), c1.getY() + my);
            return true;
        } else {
            if (c1.getX() > 0 && ground[c1.getX() - 1][c1.getY()].isEmpty()) {
                ground[c1.getX()][c1.getY()].init();
                ground[c1.getX() - 1][c1.getY()].setCreature(c1);
                c1.setXY(c1.getX() - 1, c1.getY());
                return true;
            }
            if (c1.getX() < 9 && ground[c1.getX() + 1][c1.getY()].isEmpty()) {
                ground[c1.getX()][c1.getY()].init();
                ground[c1.getX() + 1][c1.getY()].setCreature(c1);
                c1.setXY(c1.getX() + 1, c1.getY());
                return true;
            }
        }
        return false;
    }
}
