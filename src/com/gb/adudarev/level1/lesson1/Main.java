package com.gb.adudarev.level1.lesson1;

public class Main {

    ///1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte bVar = 2;
        short sVar = 32767;
        int iVar = 2147483647;
        long lVar = 1L;
        float fVar = 2.5F;
        double dVar = 2.3;
        char cVar = 'c';
        boolean bTrue = true;
        boolean bFalse = false;

        //3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – аргументы этого метода, имеющие тип float.
        System.out.println(newMethod3(2.4f, 2.0f, 5.6f, 5.2f));

        //4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
        System.out.println(newMethod4(10, 4));

        //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
        System.out.println(newMethod5(0));

        //6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        System.out.println(newMethod6(-2));

        //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
        System.out.println(newMethod7("Максим"));

        //8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println(newMethod(2021));
    }

    private static String newMethod(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return "Год " + year + " высокосный";
        } else {
            return "Год " + year + " не высокосный";
        }
    }

    private static String newMethod7(String name) {
        return "Привет, " + name + "!";
    }

    private static boolean newMethod6(int i) {
        return i < 0; //в задании нет уточнения про 0
    }

    private static String newMethod5(int i) {
        return i >= 0 ? "Число " + i + " положительное" : "Число " + i + "  отрицательное";

    }

    private static boolean newMethod4(int i1, int i2) {
        int result = i1 + i2;
        return result >= 10 && result <= 20;
    }

    public static float newMethod3(float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }
}
