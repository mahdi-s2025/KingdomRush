package com.kingdom_rush.view;

import com.kingdom_rush.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private static Stage loginStage;

    @FXML
    private Button btn_login_LoginPage;

    @FXML
    private Label lbl_error;

    @FXML
    private Label lbl_signup;

    @FXML
    private TextField tf_login_username;

    @FXML
    private TextField tf_password_password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginStage = new Stage();
        loginStage.setTitle("Login");
        loginStage.setResizable(false);
        loginStage.initOwner(Main.getPrimaryStage());
        loginStage.initModality(Modality.WINDOW_MODAL);

    }

    public static void showLoginStage() {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("login-view.fxml"));
        try {
            loginStage.setScene(new Scene(fxmlLoader.load(), 400, 550));
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        loginStage.show();

    }
}
