package com.gb.adudarev.level3.lesson1;

import java.util.*;

public class Level3Lesson1Item1 {
    public static void start() {

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        List<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);


        ChangeArrayItems<?> changeArrayItems1 = new ChangeArrayItems<>(queue);
        System.out.println(changeArrayItems1.getObj().getClass().getName());
        System.out.println(Arrays.asList(changeArrayItems1.changeItem(1, 2)));


        ChangeArrayItems<?> changeArrayItems2 = new ChangeArrayItems<>(list);
        System.out.println(changeArrayItems2.getObj().getClass().getName());
        System.out.println(Arrays.asList(changeArrayItems2.changeItem(2, 3)));


        ChangeArrayItems<?> changeArrayItems3 = new ChangeArrayItems<>(set);
        System.out.println(changeArrayItems3.getObj().getClass().getName());
        System.out.println(Arrays.asList(changeArrayItems3.changeItem(5, 1)));


    }
}
