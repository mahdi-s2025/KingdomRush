package com.kingdom_rush.model;

public class HealthSpell implements Spell {
    private int number;
    private final int price;

    public HealthSpell(int number) {
        this.number = number;
        this.price = 50;
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
        return "health";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void drop() {

    }
}
