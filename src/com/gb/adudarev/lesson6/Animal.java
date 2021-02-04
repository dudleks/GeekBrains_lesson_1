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

/*    Animal createAnimal(int animalCounter){
        animalCounter++;
        return new Animal();
    }*/

    public void run(int length) {
        if (isLimitAvailable(length, runLengthLimit)) {
            System.out.println(name + " пробежал: " + length + "м");
        } else {
            System.out.println(name + " не может бежать дальше: " + length + "м");
        }
    }

    public void jump(int height) {
        if (isLimitAvailable(height, jumpHeightLimit)) {
            System.out.println(name + " прыгнул: " + height + "м");
        } else {
            System.out.println(name + " не может прыгать выше: " + height + "м");
        }
    }

    public void swim(int length) {
        if (isLimitAvailable(length, swimLengthLimit)) {
            System.out.println(name + " проплыл: " + length + "м");
        } else {
            System.out.println(name + " не может плыть дальше: " + length + "м");
        }
    }

    private boolean isLimitAvailable(int currentValue, int limitValue) {
        return currentValue <= limitValue;
    }

}
