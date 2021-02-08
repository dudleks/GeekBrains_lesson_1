package com.gb.adudarev.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreasedFood(int appetit) {
        if (!isEnoughFood(appetit)) {
            System.out.println("Указано неверное значение еды!");
        }
        food -= appetit;
    }

    public boolean isEnoughFood(int appetit) {
        return appetit <= food;
    }

    public void increasedFood(int food) {
        this.food += food;
    }

}