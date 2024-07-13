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

import java.util.ArrayList;
import java.util.List;

public class LittleBoySpell implements Spell {
    private int number;
    private final int price;

    public LittleBoySpell(int number) {
        this.number = number;
        this.price = 100;
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
        return "littleBoy";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void drop(Map map, AnchorPane root) {
        ArrayList<Node> nodes = new ArrayList<>(root.getChildren());
        for (Node node : nodes) {
            if (node instanceof Raider raider) {
                root.getChildren().remove(raider);
                raider.getPathTransition().stop();
            }
        }

        Player player = PlayerController.getInstance().getPlayer();
        number--;
        DBController.getInstance().updateSpell(player, getName(), number);
    }
}
