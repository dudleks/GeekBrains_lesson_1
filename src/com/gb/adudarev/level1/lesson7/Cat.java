package com.gb.adudarev.level1.lesson7;

public class Cat {
    private String name;
    private int appetite;
    boolean isHungry = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.isEnoughFood(appetite) && !isHungry) {
            p.decreasedFood(appetite);
            isHungry = true;
            System.out.println(name + " покушал и сыт!");

        } else if (isHungry) {
            System.out.println(name + " не голоден!");
        } else {
            System.out.println("В тарелке мало еды для котика " + name);
        }
    }
}
