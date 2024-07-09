package com.kingdom_rush.model;

public class LittleBoySpell implements Spell {
    private int number;
    // price

    public LittleBoySpell(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public void setNumber(int number) {

    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void drop() {

    }
}
