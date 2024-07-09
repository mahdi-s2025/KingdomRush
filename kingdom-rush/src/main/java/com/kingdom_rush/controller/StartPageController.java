package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import com.kingdom_rush.model.Images;
import com.kingdom_rush.model.Sounds;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import lombok.Getter;

import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {
    @Getter
    private static final StartPageController instance = new StartPageController();

    @FXML
    private ImageView btn_exit;

    @FXML
    private ImageView btn_start;

    private final Stage primaryStage;

    public StartPageController() {
        primaryStage = Main.getPrimaryStage();
        //mainThemeMusic = new MusicController("src/main/resources/musics/MainTheme.wav");
    }

    @FXML
    void btn_exit_mouseClicked(MouseEvent event) {
        primaryStage.close();
    }

    @FXML
    void btn_exit_mouseEntered(MouseEvent event) {
        btn_exit.setImage(Images.getImage().exit_hover);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
        mediaPlayer.play();
    }

    @FXML
    void btn_exit_mouseExited(MouseEvent event) {
        btn_exit.setImage(null);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
        mediaPlayer.play();
    }

    @FXML
    void btn_start_mouseClicked(MouseEvent event) {
        LoginController.getLoginStage().show();
    }

    @FXML
    void btn_start_mouseEntered(MouseEvent event) {
        btn_start.setImage(Images.getImage().start_hover);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
        mediaPlayer.play();
    }

    @FXML
    void btn_start_mouseExited(MouseEvent event) {
        btn_start.setImage(null);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
        mediaPlayer.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_start.setImage(null);
        btn_exit.setImage(null);
    }
}
