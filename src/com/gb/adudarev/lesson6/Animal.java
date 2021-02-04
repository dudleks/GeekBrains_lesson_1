package com.gb.adudarev.lesson6;

public class Animal {

    private int runLengthLimit;
    private int jumpHeightLimit;
    private int swimLengthLimit;
    private String name;
    private int animalCounter;


    public Animal(int runLengthLimit, int jumpHeightLimit, int swimLengthLimit, String name) {
        this.runLengthLimit = runLengthLimit;
        this.jumpHeightLimit = jumpHeightLimit;
        this.swimLengthLimit = swimLengthLimit;
        this.name = name;
    }

    public Animal(int runLengthLimit, int jumpHeightLimit, String name) {
        this.runLengthLimit = runLengthLimit;
        this.jumpHeightLimit = jumpHeightLimit;
        this.name = name;
    }


    public void run(int length) {
        if (isLimitExist(length, runLengthLimit)) {
            System.out.println(name + " пробежал: " + length + "м");
        } else {
            System.out.println(name + " не может бежать дальше: " + runLengthLimit + "м");
        }
    }

    public void jump(int height) {
        if (isLimitExist(height, jumpHeightLimit)) {
            System.out.println(name + " прыгнул: " + height + "м");
        } else {
            System.out.println(name + " не может прыгать выше: " + jumpHeightLimit + "м");
        }
    }

    public void swim(int length) {
        if (isLimitExist(length, swimLengthLimit)) {
            System.out.println(name + " проплыл: " + length + "м");
        } else {
            System.out.println(name + " не может плыть дальше: " + swimLengthLimit + "м");
        }
    }

    private boolean isLimitExist(int currentValue, int limitValue) {
        return currentValue <= limitValue;
    }

}
