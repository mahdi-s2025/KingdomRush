package com.kingdom_rush.view;

import com.kingdom_rush.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

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
            LoginView.showLoginStage();
        });


        btn_exit.hoverProperty().addListener(observable -> {
            btn_exit.setImage(Images.getImage().exit_hover);
            MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_hover);
            mediaPlayer.play();
        });

        btn_exit.setOnMouseExited(event -> btn_exit.setImage(null));
    }
}
