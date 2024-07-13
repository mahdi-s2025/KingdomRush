package com.kingdom_rush.model;

import lombok.Getter;
import lombok.Setter;

@Getter
abstract public class Tower {
    @Setter
    private int health;
    private final int destructionPower;
    private final int cost;
    private final int radius;

    public Tower(int health, int destructionPower, int cost, int radius) {
        this.health = health;
        this.destructionPower = destructionPower;
        this.cost = cost;
        this.radius = radius;

    }
}
