package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    public static Scene getSignupScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signup-view.fxml"));
        Scene signupScene = null;
        try {
            signupScene = new Scene(fxmlLoader.load(), 400, 550);

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return signupScene;
    }

    @FXML
    private Button btn_signup;

    @FXML
    private Label lbl_error;

    @FXML
    private Label lbl_login;

    @FXML
    private TextField psf_password;

    @FXML
    private TextField tf_username;


    public SignupController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BooleanBinding fieldsEmpty = tf_username.textProperty().isEmpty()
                .or(psf_password.lengthProperty().lessThan(8));
        btn_signup.disableProperty().bind(fieldsEmpty);
    }

    @FXML
    void btn_signup_action(ActionEvent event) {
        try {
            PlayerController.getInstance().signup(tf_username.getText(), psf_password.getText());
            LoginController.getLoginStage().close();
            tf_username.clear();
            psf_password.clear();
            lbl_error.setText(null);
            Main.getPrimaryStage().setScene(HomePageController.getScene());
        } catch (Exception e) {
            lbl_error.setText(e.getMessage());
        }
    }

    @FXML
    void btn_signup_mouseEntered(MouseEvent event) {
        btn_signup.setTextFill(Color.WHEAT);
        btn_signup.setStyle("-fx-background-color: red; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");
    }

    @FXML
    void btn_signup_mouseExited(MouseEvent event) {
        btn_signup.setTextFill(Color.BLACK);
        btn_signup.setStyle("-fx-background-color: pink; -fx-border-width: 2px; -fx-border-color: red; -fx-background-radius: 20; -fx-border-radius: 20;");
    }

    @FXML
    void lbl_login_mouseClicked(MouseEvent event) {
        LoginController.getLoginStage().setTitle("Login");
        LoginController.getLoginStage().setScene(LoginController.getLoginScene());
    }

    @FXML
    void lbl_login_mouseEntered(MouseEvent event) {
        lbl_login.setTextFill(Color.GRAY);
    }

    @FXML
    void lbl_login_mouseExited(MouseEvent event) {
        lbl_login.setTextFill(Color.BLACK);
    }
}
