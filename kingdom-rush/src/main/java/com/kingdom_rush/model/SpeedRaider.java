package com.kingdom_rush.model;

import lombok.Getter;

@Getter
public class SpeedRaider extends Raider {
    public SpeedRaider() {
        super(100, 20, 20, 2, Images.getImage().speed, RaiderType.SPEED);
        setFitWidth(55);
        setFitHeight(50);
    }
}
