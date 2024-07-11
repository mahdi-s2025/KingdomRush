package com.kingdom_rush.model;

import javafx.scene.image.Image;

public class Images {
    private static Images image;

    public Image exit_hover, start_hover, setting, setting_hover, shop, shop_hover, mute, unmute;

    private Images() {
        String imagesPath = "file:src/main/resources/";
        exit_hover = new Image(imagesPath + "start-page/exit-hover.jpg");
        start_hover = new Image(imagesPath + "start-page/start-hover.png");
        setting = new Image(imagesPath + "home-page/setting.jpg");
        setting_hover = new Image(imagesPath + "home-page/setting-hover.png");
        shop = new Image(imagesPath + "home-page/shop.png");
        shop_hover = new Image(imagesPath + "home-page/shop-hover.png");
        mute = new Image(imagesPath + "home-page/mute.png");
        unmute = new Image(imagesPath + "home-page/unmute.png");
    }

    public static Images getImage() {
        if (image == null) {
            image = new Images();
        }
        return image;
    }

}
