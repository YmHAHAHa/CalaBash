package gui;


import BattleField.Field;
import BattleField.IVmanager;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;


public class LayoutControl {

    private Field field;

    @FXML
    private GridPane mainPane;

    public void setField(Field field) {
        this.field = field;
    }

    public void paintAllView() {
        for (int i = 0; i < field.allView.size(); ++i) {
            IVmanager tmp = field.allView.get(i);
            mainPane.add(tmp.iv, tmp.x, tmp.y);
        }
    }

    public void paintOne(int i) {
        IVmanager tmp = field.allView.get(i);
        mainPane.getChildren().remove(tmp.iv);
        mainPane.add(tmp.iv, tmp.x, tmp.y);
    }
}
