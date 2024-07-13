package com.kingdom_rush.model;

import javafx.scene.image.Image;

public class Images {
    private static Images image;

    public Image exit_hover, start_hover, setting, setting_hover, shop, shop_hover, mute, unmute;
    public Image buy_hover, tick_hover, shop_coin, shop_health, shop_freeze, shop_little_boy;
    public Image map_1, map_2, map_3, map_4;
    public Image archer, mage, bertha, tower_place, tower_bar, update_bar;
    public Image speed, shield, fly;


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
        map_1 = new Image(imagesPath + "map/map-1.jpg");
        map_2 = new Image(imagesPath + "map/map-2.jpg");
        map_3 = new Image(imagesPath + "map/map-3.jpg");
        map_4 = new Image(imagesPath + "map/map-4.jpg");
        archer = new Image(imagesPath + "map/archer.png");
        mage = new Image(imagesPath + "map/mage.png");
        bertha = new Image(imagesPath + "map/bertha.png");
        tower_place = new Image(imagesPath + "map/tower-place.png");
        tower_bar = new Image(imagesPath + "map/tower-bar.png");
        update_bar = new Image(imagesPath + "map/update-bar.png");
        speed = new Image(imagesPath + "map/speed.gif");
        shield = new Image(imagesPath + "map/shield.gif");
        fly = new Image(imagesPath + "map/fly.gif");
    }

    public static Images getImage() {
        if (image == null) {
            image = new Images();
        }
        return image;
    }

}
