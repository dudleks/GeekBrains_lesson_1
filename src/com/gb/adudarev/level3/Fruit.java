package com.gb.adudarev.level3;

public abstract class Fruit {

    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public abstract Fruit getFruit();
}