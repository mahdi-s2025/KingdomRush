package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import com.kingdom_rush.model.Images;
import com.kingdom_rush.model.Sounds;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {

    @FXML
    private ImageView btn_exit;

    @FXML
    private ImageView btn_start;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_start.setImage(null);
        btn_exit.setImage(null);

        Stage primaryStage = Main.getPrimaryStage();

        btn_start.hoverProperty().addListener(observable -> {
            btn_start.setImage(Images.getImage().start_hover);
            MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
            mediaPlayer.play();
        });

        btn_start.setOnMouseExited(event -> btn_start.setImage(null));

        btn_start.setOnMouseClicked(event -> {
            LoginController.getInstance().getLoginStage().show();
        });


        btn_exit.hoverProperty().addListener(observable -> {
            btn_exit.setImage(Images.getImage().exit_hover);
            MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
            mediaPlayer.play();
        });

        btn_exit.setOnMouseExited(event -> btn_exit.setImage(null));

        btn_exit.setOnMouseClicked(event -> primaryStage.close());
    }
}
