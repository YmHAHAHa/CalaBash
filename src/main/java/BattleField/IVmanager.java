package BattleField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IVmanager {
    public ImageView iv;
    public int x, y;

    public IVmanager(int x1, int y1, Image image) {
        iv = new ImageView();
        iv.setImage(image);
        iv.setFitWidth(70);
        iv.setFitHeight(70);
        this.x = x1;
        this.y = y1;
    }
}
