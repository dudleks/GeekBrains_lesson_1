package com.gb.adudarev.lesson6;

/*1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
        Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
        4. * Добавить подсчет созданных котов, собак и животных.*/

public class MainClassLesson6 {
    public static void main(String[] args) {

        AnimalCreator animalCreator = new AnimalCreator();

        int animalCount = 5;
        for (int i = 1; i <= animalCount; i++) {
            Cat cat = animalCreator.createCat(100, 10, "Мурка" + i);
            cat.run(10);
            cat.swim(9);
            cat.jump(5);
            System.out.println();

            Dog dog = animalCreator.createDog(200, 1, 10, "Бобик" + i);
            dog.run(150);
            dog.swim(10);
            dog.jump(5);
            System.out.println();
        }

        System.out.println("Котов создано: " + animalCreator.getCatCounter());
        System.out.println("Собак создано: " + animalCreator.getDogCounter());
    }


}
