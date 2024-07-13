package com.kingdom_rush.model;


import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;

abstract public class Raider extends ImageView {
    @Setter @Getter
    private int health;
    @Getter
    private final int loot;
    @Getter
    private final int power;
    @Getter
    private final PathTransition pathTransition;
    @Setter
    private Path path;
    @Getter
    private final RaiderType raiderType;


    public Raider(int health, int speed, int loot, int power, Image image, RaiderType raiderType) {
        this.health = health;
        this.loot = loot;
        this.power = power;
        this.raiderType = raiderType;

        setImage(image);
        setPreserveRatio(true);
        setSmooth(true);

        pathTransition = new PathTransition();
        pathTransition.setNode(this);
        pathTransition.setDuration(Duration.millis(speed * 1000));
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
    }

    public void move() {
        pathTransition.setPath(path);
        pathTransition.play();
    }
}
