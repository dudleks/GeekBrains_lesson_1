package com.gb.adudarev.level2.lesson1;

public class Human implements Champions {
    private String name;
    private int maxRunDistance;
    private int maxJumpDistance;
    private boolean onDistance;

    public Human(String name, int maxRunDistance, int maxJumpDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int length) {
        if (length <= maxRunDistance) {
            System.out.println(name + " пробежал " + length + " м");
        } else {
            System.out.println(name + " не пробежал " + length + " м");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpDistance) {
            System.out.println(name + " прыгнул " + height + " м");
        } else {
            System.out.println(name + " не прыгнул " + height + " м");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(name + " " + onDistance);
    }
}