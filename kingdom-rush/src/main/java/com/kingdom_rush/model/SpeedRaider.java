package com.kingdom_rush.model;

import lombok.Getter;

@Getter
public class SpeedRaider extends Raider {
    private final RaiderType raiderType;

    public SpeedRaider() {
        super(100, 20, 20, 2, Images.getImage().speed);
        this.raiderType = RaiderType.SPEED;
//        this.setFitWidth(65);
//        this.setFitHeight(54);
        setFitWidth(55);
        setFitHeight(50);
    }
}
