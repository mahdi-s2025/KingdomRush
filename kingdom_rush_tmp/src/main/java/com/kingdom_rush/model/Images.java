package com.kingdom_rush.model;

import javafx.scene.image.Image;

public class Images {
    private static Images image;

    public Image exit_hover, start_hover;

    private Images() {
        String imagesPath = "file:src/main/resources/start-page/";
        exit_hover = new Image(imagesPath + "exit_hover.jpg");
        start_hover = new Image(imagesPath + "start_hover.png");
    }

    public static Images getImage() {
        if (image == null) {
            image = new Images();
        }
        return image;
    }

}
