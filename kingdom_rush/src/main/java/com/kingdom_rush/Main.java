package com.kingdom_rush;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-video-view.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Kingdom Rush");
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("start-page-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load(), 1280, 720);

        new Thread(() -> {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                primaryStage.setScene(scene2);
            });
        }).start();

    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}