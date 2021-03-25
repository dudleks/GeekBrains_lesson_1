package com.gb.adudarev.level3.lesson1;

public class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public Fruit getFruit() {
        return new Orange();
    }
}