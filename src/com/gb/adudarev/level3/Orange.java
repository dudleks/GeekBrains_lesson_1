package com.gb.adudarev.level3;

public class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public Fruit getFruit() {
        return new Orange();
    }
}