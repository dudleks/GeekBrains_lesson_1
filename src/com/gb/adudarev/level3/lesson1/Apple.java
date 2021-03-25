package com.gb.adudarev.level3.lesson1;

public class Apple extends Fruit {

    public Apple() {
        super(1.0f);
    }

    @Override
    public Fruit getFruit() {
        return new Apple();

    }
}
