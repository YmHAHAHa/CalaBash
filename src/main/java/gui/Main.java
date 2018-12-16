package gui;

import BattleField.Field;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    private LayoutControl control;
    private Field field;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("layout.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        fxmlLoader.load();
        control = fxmlLoader.getController();
        field = new Field(control);
        Parent root = fxmlLoader.getRoot();
        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Final Battle");
        stage.setResizable(false);
        //field.testHULU();
        stage.setScene(scene);
        stage.show();
    }

}
