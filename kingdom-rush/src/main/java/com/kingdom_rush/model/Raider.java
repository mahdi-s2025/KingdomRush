package com.kingdom_rush.model;


import lombok.Getter;
import lombok.Setter;

@Getter
abstract public class Raider {
    private final int health;
    // speed
    private final int loot;
    // path corners; it better to implement in map class


    public Raider(int health, int loot) { // and speed and path corners in parameters
        this.health = health;
        this.loot = loot;
    }
}
