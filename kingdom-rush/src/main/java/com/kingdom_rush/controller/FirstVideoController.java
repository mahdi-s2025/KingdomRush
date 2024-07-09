package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstVideoController implements Initializable {
    @Getter
    private static final FirstVideoController instance = new FirstVideoController();

    @FXML
    private MediaView mediaView;

    private final Stage primaryStage;
    private Scene nextScene;

    public FirstVideoController() {
        primaryStage = Main.getPrimaryStage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = "src/main/resources/start.mp4";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void changeScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("start-page-view.fxml"));
        try {
            nextScene = new Scene(fxmlLoader.load(), 1280, 720);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        primaryStage.setScene(nextScene);
    }
}
