package com.kingdom_rush.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ffffff implements Initializable {
    @FXML
    private MediaView mediaView;

    @Getter
    private static ffffff instance;
    private ffffff() {}

    private Stage primaryStage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        primaryStage = Main.getPrimaryStage();
//        try {
//
//        } catch (IOException e) {
//            e.printStackTrace(System.err);
//        }
        System.out.println("Hi");
        String path = "src/main/resources/start.mp4";
        Media media = new Media(new File(path).toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void changeScene() {
        primaryStage.setScene(scene);
    }
}
