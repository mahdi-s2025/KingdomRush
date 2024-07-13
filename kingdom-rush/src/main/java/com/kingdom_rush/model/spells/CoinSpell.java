package com.kingdom_rush.model.spells;

import com.kingdom_rush.controller.DBController;
import com.kingdom_rush.controller.PlayerController;
import com.kingdom_rush.model.Map;
import com.kingdom_rush.model.Player;
import javafx.scene.layout.AnchorPane;

public class CoinSpell implements Spell {
    private int number;
    private final int price;

    public CoinSpell(int number) {
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
        return "coin";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void drop(Map map, AnchorPane root) {
        Player player = PlayerController.getInstance().getPlayer();
        number--;
        DBController.getInstance().updateSpell(player, getName(), number);
        map.setCoin(map.getCoin() + 250);
    }
}
