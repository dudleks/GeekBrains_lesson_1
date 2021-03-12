package com.gb.adudarev.level1.lesson7;

/*
    1. Расширить задачу про котов и тарелки с едой.
    2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
    3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
    4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
    5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
    6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/

import java.util.Random;

public class MainClassLesson7 {

    public static void main(String[] args) {
        Cat[] catsArray = new Cat[5];
        Plate p = new Plate(20);

        for (int i = 0; i < catsArray.length; i++) {
            catsArray[i] = new Cat("Baris" + i, new Random().nextInt(100));
        }

        for (int i = 0; i < catsArray.length; i++) {
            catsArray[i].eat(p);
        }
        System.out.println("---------");
        p.increasedFood(50);

        for (int i = 0; i < catsArray.length; i++) {
            catsArray[i].eat(p);
        }
    }
}
