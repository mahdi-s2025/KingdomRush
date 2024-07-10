package com.kingdom_rush.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private int ID;
    private String username;
    private String password;
    private int level;
    private int diamondsNum;
    private Spell[] backpack;
    private int[] stars;

    public Player(String username, String password, int level, int diamondsNum, Spell[] backpack, int[] stars) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.diamondsNum = diamondsNum;
        this.backpack = backpack;
        this.stars = stars;
    }
}
