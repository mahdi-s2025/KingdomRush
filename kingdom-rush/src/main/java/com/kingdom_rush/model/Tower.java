package com.kingdom_rush.model;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

@Getter
abstract public class Tower extends ImageView {
    @Setter
    private int health;
    @Getter
    private final int destructionPower;
    @Setter @Getter
    private static int cost;
    private final int radius;

    public Tower(int health, int destructionPower, int radius, Image image) {
        this.health = health;
        this.destructionPower = destructionPower;
        this.radius = radius;

        setImage(image);
        setPreserveRatio(true);
        setSmooth(true);
        setCursor(Cursor.HAND);
    }
}
