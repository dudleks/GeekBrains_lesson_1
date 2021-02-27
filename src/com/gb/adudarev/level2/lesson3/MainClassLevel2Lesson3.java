package com.gb.adudarev.level2.lesson3;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class MainClassLevel2Lesson3 {
    public static void main(String[] args) {

        //        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        //                Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        //                Посчитать сколько раз встречается каждое слово.
        String[] words = {"apple", "leak", "orange", "pear", "lemon", "grape", "banana", "apricot", "avocado", "broccoli", "nut", "garlic", "mango",
                "carrot", "banana", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "pear", "mushroom", "cherry", "broccoli", "apple", "melon", "banana", "orange"};

        ArrayList<String> currentList = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> mainList = new ArrayList<>(Arrays.asList(words));

        HashMap hashMap = new HashMap();

        for (String s : currentList) {
            int counter = 0;
            for (String s1 : mainList) {
                if (s.equals(s1)) {
                    counter++;
                }
            }
            hashMap.put(s, counter);
        }
        System.out.println(hashMap);
    }

    //        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    //                В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
    //                Следует учесть, что под одной фамилией может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
    //                Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
    //                Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().


}
