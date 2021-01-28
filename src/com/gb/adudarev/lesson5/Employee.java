package com.gb.adudarev.lesson5;

//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
public class Employee {

    private String FIO;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    //2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String FIO, String position, String email, String phone, double salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //   3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    void printEmployeeInfo() {
        System.out.println(
                "FIO='" + FIO +
                        "\nposition='" + position +
                        "\nemail='" + email +
                        "\nphone='" + phone +
                        "\nsalary=" + salary +
                        "\nage=" + age + "\n");
    }

    public int getAge() {
        return age;
    }
}



