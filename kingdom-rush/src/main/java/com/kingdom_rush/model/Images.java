package com.kingdom_rush.model;

import javafx.scene.image.Image;

public class Images {
    private static Images image;

    public Image exit_hover, start_hover, setting, setting_hover, shop, shop_hover, mute, unmute;
    public Image buy_hover, tick_hover, shop_coin, shop_health, shop_freeze, shop_little_boy;

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
        buy_hover = new Image(imagesPath + "shop-page/buy-hover.jpg");
        tick_hover = new Image(imagesPath + "shop-page/tick-hover.jpg");
        shop_coin = new Image(imagesPath + "shop-page/shop-coin.jpg");
        shop_health = new Image(imagesPath + "shop-page/shop-health.jpg");
        shop_freeze = new Image(imagesPath + "shop-page/shop-freeze.jpg");
        shop_little_boy =  new Image(imagesPath + "shop-page/shop-little-boy.jpg");
    }

    public static Images getImage() {
        if (image == null) {
            image = new Images();
        }
        return image;
    }

}
