package com.kingdom_rush.model;

import com.kingdom_rush.controller.MapController;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;
import lombok.Getter;

@Getter
public class FlyRaider extends Raider {
    public FlyRaider() {
        super(250, 35, 50, 3, Images.getImage().fly, RaiderType.FLY);
        this.setFitWidth(77);
        this.setFitHeight(60);
    }
}
