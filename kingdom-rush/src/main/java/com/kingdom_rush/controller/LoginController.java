package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

public class LoginController {
    @Getter
    private static final Stage loginStage;

    @Getter
    private static final Scene loginScene;

    private static final Stage primaryStage;

    static {
        primaryStage = Main.getPrimaryStage();
        loginStage = new Stage();
        loginStage.setTitle("Login");
        loginStage.setResizable(false);
        loginStage.initOwner(Main.getPrimaryStage());
        loginStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene tmp = null;
        try {
            tmp = new Scene(fxmlLoader.load(), 400, 550);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        loginScene = tmp;
        loginStage.setScene(loginScene);
    }

    @FXML
    private Button btn_login;

    @FXML
    private Label lbl_error;

    @FXML
    private Label lbl_signup;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

    // initialize method

    @FXML
    void btn_login_action(ActionEvent event) {

    }

    @FXML
    void btn_login_mouseEntered(MouseEvent event) {
        btn_login.setTextFill(Color.WHEAT);
        btn_login.setStyle("-fx-background-color: red; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");
    }

    @FXML
    void btn_login_mouseExited(MouseEvent event) {
        btn_login.setTextFill(Color.BLACK);
        btn_login.setStyle("-fx-background-color: pink; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");
    }

    @FXML
    void lbl_signup_mouseClicked(MouseEvent event) {
        loginStage.setTitle("Signup");
        loginStage.setScene(SignupController.getSignupScene());
    }

    @FXML
    void lbl_signup_mouseEntered(MouseEvent event) {
        lbl_signup.setTextFill(Color.GRAY);
    }

    @FXML
    void lbl_signup_mouseExited(MouseEvent event) {
        lbl_signup.setTextFill(Color.BLACK);
    }
}
