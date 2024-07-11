package com.kingdom_rush.model;

import lombok.Getter;
import lombok.Setter;

public class Map {
}

@Getter
@Setter
class coordination {
    private int x;
    private int y;

    public coordination(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
