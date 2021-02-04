package com.gb.adudarev.lesson6;

/*1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
        Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
        4. * Добавить подсчет созданных котов, собак и животных.*/

public class MainClassLesson6 {
    public static void main(String[] args) {

        Cat cat = new Cat(100, 10, "Мурка");
        cat.run(100);
        cat.swim(10);
        cat.jump(5);

        Dog dog = new Dog(100, 10, 10, "Бобик");
        dog.run(100);
        dog.swim(10);
        dog.jump(5);
    }
}
