package com.kingdom_rush.model;

import com.kingdom_rush.controller.MusicController;
import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Map {
    private final MusicController musicController;
    private final Image mapImage;
    private final int[][] towerCoordinations;
    private final Wave[] waves;
    private int coin;
    private int health;
    private final int maxHealth;

    public Map(Image mapImage, int[][] towerCoordinations, int coin, int health, MusicController musicController, Wave[] waves) {
        this.mapImage = mapImage;
        this.musicController = musicController;
        this.towerCoordinations = towerCoordinations;
        this.coin = coin;
        this.health = health;
        this.maxHealth = health;
        this.waves = waves;
    }
}
