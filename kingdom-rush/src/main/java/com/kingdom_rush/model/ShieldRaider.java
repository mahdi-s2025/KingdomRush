package com.kingdom_rush.model;

import com.kingdom_rush.controller.MapController;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;
import lombok.Getter;

@Getter
public class ShieldRaider extends Raider {
    public ShieldRaider() {
        super(500, 55, 100, 5, Images.getImage().shield, RaiderType.SPEED);
        this.setFitWidth(80);
        this.setFitHeight(69);
    }
}
