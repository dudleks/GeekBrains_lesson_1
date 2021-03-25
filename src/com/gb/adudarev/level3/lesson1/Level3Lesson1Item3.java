package com.gb.adudarev.level3.lesson1;

public class Level3Lesson1Item3 {
    public static void start() {
        Box<Fruit> box1 = new Box<>();
        System.out.println("Box1 weight is " + box1.getWeight());
        Box<Apple> box2 = new Box<>();
        System.out.println("Box2 weight is " + box2.getWeight());
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());
        System.out.println("add two Apple to box2");
        System.out.println("Box2 weight is " + box2.getWeight());
        box2.transfer(box1);
        System.out.println("Box2 > Box1");
        System.out.println("Box1 weight is " + box1.getWeight());
        System.out.println("Box2 weight is " + box2.getWeight());
    }
}