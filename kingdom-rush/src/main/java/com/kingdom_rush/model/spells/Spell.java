package com.kingdom_rush.model.spells;

import com.kingdom_rush.model.Map;
import javafx.scene.layout.AnchorPane;

public interface Spell {
    int getNumber();
    void setNumber(int number);
    String getName();
    int getPrice();
    void drop(Map map, AnchorPane root);
}
