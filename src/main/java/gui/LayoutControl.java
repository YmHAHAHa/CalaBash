package gui;


import BattleField.Field;
import Beings.CalaBashBro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


public class LayoutControl {

    private Field field;

    public void setField(Field field) {
        this.field = field;
    }

    @FXML
    private GridPane mainPane;

    public void setIV(ImageView iv, int x, int y) {
        mainPane.add(iv, x, y);
    }
}
