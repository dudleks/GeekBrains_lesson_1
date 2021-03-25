package com.gb.adudarev.level3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private final ArrayList<T> list;

    public Box(T... arr) {
        list = new ArrayList<>(Arrays.asList(arr));
    }

    public float getWeight() {
        if (list.size() == 0) return 0.0f;
        return (float) (list.get(0).getWeight() * list.size());
    }

    public void addFruit(T fruit) {
        list.add(fruit);
    }

    public boolean compare(Box<T> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00001;
    }

    public void transfer(Box<? super T> another) {
        another.list.addAll(this.list);
        this.list.clear();
    }
}