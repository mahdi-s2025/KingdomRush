package com.kingdom_rush.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPageView implements Initializable {

    @FXML
    private ImageView btn_login;

    @FXML
    private ImageView btn_signup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_signup.setOnMouseEntered(event -> {
            btn_signup.setImage(Images.getImage().signup_hover);
            MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
            mediaPlayer.play();
        });

        btn_signup.setOnMouseExited(event -> btn_signup.setImage(Images.getImage().signup));

        btn_login.setOnMouseEntered(event -> {
            btn_login.setImage(Images.getImage().login_hover);
            MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
            mediaPlayer.play();
        });

        btn_login.setOnMouseExited(event -> btn_login.setImage(Images.getImage().login));

    }
}
