package com.gb.adudarev.lesson6;

public class Cat extends Animal {

    public Cat(int runLength, int jumpHeight, String name) {
        super(runLength, jumpHeight, name);
    }

    @Override
    public void swim(int length) {
        System.out.println("Кошки не плавают!");
    }


}
