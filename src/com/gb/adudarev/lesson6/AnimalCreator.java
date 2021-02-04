package com.gb.adudarev.lesson6;

public class AnimalCreator {

    private int catCounter;
    private int dogCounter;

    Cat createCat(int runLength, int jumpHeight, String name) {
        catCounter++;
        return new Cat(runLength, jumpHeight, name);
    }

    Dog createDog(int runLength, int jumpLength, int swimLength, String name) {
        dogCounter++;
        return new Dog(runLength, jumpLength, swimLength, name);
    }


    public int getDogCounter() {
        return dogCounter;
    }

    public int getCatCounter() {
        return catCounter;
    }
}
