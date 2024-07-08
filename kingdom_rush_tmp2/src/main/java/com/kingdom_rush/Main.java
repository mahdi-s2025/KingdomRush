package com.kingdom_rush;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

public class Main extends Application {
    @Getter
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Kingdom Rush");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-video-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        primaryStage.show();

//        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("start-page-view.fxml"));
//        Scene scene2 = new Scene(fxmlLoader2.load(), 1280, 720);
//
//        new Thread(() -> {
//            try {
//                Thread.sleep(3500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            Platform.runLater(() -> {
//                primaryStage.setScene(scene2);
//            });
//        }).start();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}