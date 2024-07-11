package com.kingdom_rush;

import com.kingdom_rush.controller.FirstVideoController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    @Getter
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Kingdom Rush");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-video-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> FirstVideoController.getInstance().changeScene());
        }).start();
    }

    public static void main(String[] args) {
        launch();
    }
}