package BattleField;

import javafx.application.Platform;

import java.io.File;
import java.util.Scanner;

public class Redo implements Runnable {
    Scanner scanner;
    int[] dtmp = new int[4];
    Field field;

    public Redo(File file, Field f) {
        this.field = f;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {

        }
    }

    public void run() {
        while (!Thread.interrupted()) {
            boolean goon = scanner.hasNextLine();
            if (goon) {
                String str = scanner.nextLine();
                String[] arr = str.split(" ");
                for (int i = 0; i < arr.length; ++i) {
                    dtmp[i] = Integer.parseInt(arr[i]);
                }
                field.doView(dtmp);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        field.drawOneCreature(dtmp[1]);
                    }
                });
            }
            try {
                if (goon) {
                    Thread.sleep(50);
                } else {
                    field.shutRedo();
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
