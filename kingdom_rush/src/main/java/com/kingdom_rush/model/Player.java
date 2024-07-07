package com.kingdom_rush.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final int ID;
    private String username;
    private String password;
    private int level;
    private int diamondsNum;
    // backpack

    public Player(int ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }
}
