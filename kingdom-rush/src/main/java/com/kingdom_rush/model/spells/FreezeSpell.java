package com.kingdom_rush.model.spells;

import com.kingdom_rush.controller.DBController;
import com.kingdom_rush.controller.PlayerController;
import com.kingdom_rush.model.Images;
import com.kingdom_rush.model.Map;
import com.kingdom_rush.model.Player;
import com.kingdom_rush.model.Raider;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class FreezeSpell implements Spell {
    private int number;
    private final int price;

    public FreezeSpell(int number) {
        this.number = number;
        this.price = 50;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getName() {
        return "freeze";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void drop(Map map, AnchorPane root) {

        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        for (Node node : root.getChildren()) {
            if (node == null) {
                root.getChildren().remove(null);
                continue;
            }
            if (node instanceof Raider raider) {
                if (raider.getImage() == null) continue;
                if (raider.getImage().equals(Images.getImage().speed)) {
                    raider.setImage(Images.getImage().speed_stop);
                } else if (raider.getImage().equals(Images.getImage().shield)) {
                    raider.setImage(Images.getImage().shield_stop);
                } else if (raider.getImage().equals(Images.getImage().fly)) {
                    raider.setImage(Images.getImage().fly_stop);
                }
                raider.getPathTransition().pause();
            }
        }
        pause.play();
        pause.setOnFinished(event -> {
            for (Node node : root.getChildren()) {
                if (node == null) {
                    root.getChildren().remove(null);
                    continue;
                }
                if (node instanceof Raider raider) {
                    if (raider.getImage() == null) continue;
                    if (raider.getImage().equals(Images.getImage().speed_stop)) {
                        raider.setImage(Images.getImage().speed);
                    } else if (raider.getImage().equals(Images.getImage().shield_stop)) {
                        raider.setImage(Images.getImage().shield);
                    } else if (raider.getImage().equals(Images.getImage().fly_stop)) {
                        raider.setImage(Images.getImage().fly);
                    }
                    raider.getPathTransition().play();
                }
            }
        });
        Player player = PlayerController.getInstance().getPlayer();
        number--;
        DBController.getInstance().updateSpell(player, getName(), number);
    }
}
