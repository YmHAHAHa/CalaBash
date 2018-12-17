package gui;

import BattleField.Field;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
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
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!field.onBattle && !field.onReplay) {
                    if (event.getCode() == KeyCode.SPACE)
                        field.startBattle();
                    else if (event.getCode() == KeyCode.L) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Open");
                        File file = fileChooser.showOpenDialog(stage);
                        field.rePlay(file);
                    }
                }
            }
        });
        stage.setTitle("Final Battle");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }

}
