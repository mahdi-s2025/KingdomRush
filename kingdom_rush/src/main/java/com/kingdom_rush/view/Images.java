package com.kingdom_rush.view;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class Images {
    private static Images image;

    protected Image login, login_hover;
    protected Image signup, signup_hover;

    private Images() {
        String imagesPath = "file:src/main/resources/start-page/";
        login = new Image(imagesPath + "login.png");
        //System.out.println("Hi");
        login_hover = new Image(imagesPath + "login_hover.jpg");
        signup = new Image(imagesPath + "signup.jpg");
        signup_hover = new Image(imagesPath + "signup_hover.jpg");
    }

    public static Images getImage() {
        if (image == null) {
            image = new Images();
        }
        return image;
    }

}
