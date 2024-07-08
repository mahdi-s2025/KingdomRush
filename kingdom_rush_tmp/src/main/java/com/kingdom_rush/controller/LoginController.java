package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    private static LoginController instance;

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    @Getter
    private final Stage loginStage;

    private LoginController() {
        loginStage = new Stage();
        loginStage.setTitle("Login");
        loginStage.setResizable(false);
        loginStage.initOwner(Main.getPrimaryStage());
        loginStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 550);
            loginStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        initialize();
    }

    @FXML
    private Button btn_login;

    @FXML
    private Label lbl_error;

    @FXML
    private Label lbl_signup;

    @FXML
    private TextField tf_login_username;

    @FXML
    private TextField tf_login_password;


    private void initialize() {
        lbl_signup.hoverProperty().addListener(observable -> {
            System.out.println("HI");
            lbl_signup.setTextFill(Color.GRAY);
        });

        btn_login.hoverProperty().addListener(observable -> {
            System.out.println("Hi");
            btn_login.setTextFill(Color.WHEAT);
            btn_login.setStyle("-fx-background-color: red;");
        });
    }
}
