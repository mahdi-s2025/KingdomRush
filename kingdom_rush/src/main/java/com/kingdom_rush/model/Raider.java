package com.kingdom_rush.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Raider {
    private int health;
    // speed
    private int loot;
    // path corners


    public Raider(int health, int loot) { // and speed and path corners in parameters
        this.health = health;
        this.loot = loot;
    }
}
