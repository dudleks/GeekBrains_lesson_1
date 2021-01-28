package com.gb.adudarev.lesson5;


import java.util.Random;

public class MainClassLesson5 {
    public static void main(String[] args) {
        //4. Создать массив из 5 сотрудников.
        Employee[] employeeArray = new Employee[5];
        for (int i = 0; i < employeeArray.length; i++) {
            employeeArray[i] = new Employee("Ivanov Ivan Ivanovich" + i, "Tester" + i,
                    "mail" + i + "@mail.ru", "+7(999)134-12-0" + i,
                    new Random().nextDouble() * 10000.0, new Random().nextInt(100));
        }

        //5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (int j = 0; j < employeeArray.length; j++) {
            if (employeeArray[j].getAge() > 40) {
                employeeArray[j].printEmployeeInfo();
            }
        }
    }
}

