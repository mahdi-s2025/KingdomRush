package com.kingdom_rush.model.spells;

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
    public void drop() {

    }
}
