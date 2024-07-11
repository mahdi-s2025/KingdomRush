package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import com.kingdom_rush.model.Images;
import com.kingdom_rush.model.Sounds;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingController implements Initializable {
    @Getter
    private final static Stage settingStage;

    @Getter
    private final static SettingController instance;

    static {
        settingStage = new Stage();
        settingStage.setTitle("Settings");
        settingStage.setResizable(false);
        settingStage.initOwner(Main.getPrimaryStage());
        settingStage.initModality(Modality.WINDOW_MODAL);
        settingStage.initStyle(StageStyle.TRANSPARENT);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("setting-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 450);
            settingStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        instance = new SettingController();
    }

    @FXML
    private Button btn_change_password;

    @FXML
    private Button btn_change_username;

    @FXML
    private ImageView btn_close;

    @FXML
    private ImageView btn_sound;

    @FXML
    private Label lbl_error;

    @FXML
    private TextField tf_new_password;

    @FXML
    private TextField tf_new_username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BooleanBinding fieldsEmpty = tf_new_username.textProperty().isEmpty();
        btn_change_username.disableProperty().bind(fieldsEmpty);

        BooleanBinding fieldsEmpty2 = tf_new_password.textProperty().isEmpty();
        btn_change_password.disableProperty().bind(fieldsEmpty2);

        tf_new_password.setOnMouseClicked(event -> lbl_error.setText(null));
        tf_new_username.setOnMouseClicked(event -> lbl_error.setText(null));
    }

    @FXML
    void btn_change_password_action(ActionEvent event) {
        String password = tf_new_password.getText();
        try {
            PlayerController.getInstance().checkPassword(password);
            PlayerController.getInstance().getPlayer().setPassword(password);
            DBController.getInstance().updatePlayer(PlayerController.getInstance().getPlayer(), "password", password);
            tf_new_password.clear();
            lbl_error.setTextFill(Color.GREEN);
            lbl_error.setText("Done!");
        } catch (Exception e) {
            lbl_error.setTextFill(Color.RED);
            lbl_error.setText(e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    @FXML
    void btn_change_password_mouseEntered(MouseEvent event) {
        btn_change_password.setTextFill(Color.WHEAT);
        btn_change_password.setStyle("-fx-background-color: red; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");
    }

    @FXML
    void btn_change_password_mouseExited(MouseEvent event) {
        btn_change_password.setTextFill(Color.BLACK);
        btn_change_password.setStyle("-fx-background-color: pink; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");
    }

    @FXML
    void btn_change_username_action(ActionEvent event) {
        String username = tf_new_username.getText();
        try {
            PlayerController.getInstance().checkUsername(username);
            PlayerController.getInstance().getPlayer().setPassword(username);
            DBController.getInstance().updatePlayer(PlayerController.getInstance().getPlayer(), "username", username);
            tf_new_username.clear();
            lbl_error.setTextFill(Color.GREEN);
            lbl_error.setText("Done!");
        } catch (Exception e) {
            lbl_error.setTextFill(Color.RED);
            lbl_error.setText(e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    @FXML
    void btn_change_username_mouseEntered(MouseEvent event) {
        btn_change_username.setTextFill(Color.WHEAT);
        btn_change_username.setStyle("-fx-background-color: red; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");
    }

    @FXML
    void btn_change_username_mouseExited(MouseEvent event) {
        btn_change_username.setTextFill(Color.BLACK);
        btn_change_username.setStyle("-fx-background-color: pink; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");

    }

    @FXML
    void btn_close_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_click);
        mediaPlayer.play();
        lbl_error.setText(null);
        tf_new_password.clear();
        tf_new_username.clear();
        settingStage.close();
    }

    @FXML
    void btn_sound_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_click);
        mediaPlayer.play();
        if (btn_sound.getImage().equals(Images.getImage().mute)) {
            HomePageController.getMainThemeMusic().unmute();
            btn_sound.setImage(Images.getImage().unmute);
        }
        else {
            HomePageController.getMainThemeMusic().mute();
            btn_sound.setImage(Images.getImage().mute);
        }
    }
}
