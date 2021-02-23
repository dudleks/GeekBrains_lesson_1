package com.gb.adudarev.level2.lesson2;


//        1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось
//        (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
//        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.

import java.util.Scanner;

public class MainClassLevel2Lesson2 {

    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        int caseValue;
        do {
            String[][] array = new String[][]{};
            caseValue = getCase();
            try {

                switch (caseValue) {
                    case 1:
                        array = new String[][]{{"1", "3", "4", "4"}, {"1", "3", "4", "4"}, {"1", "3", "4", "4"}, {"1", "3", "4"}};
                        break;
                    case 2:
                        array = new String[][]{{"1", "3", "4", "4"}, {"S", "3", "4", "4"}, {"1", "3", "4", "4"}, {"1", "3", "4", "4"}};
                        break;
                    case 3:
                        array = new String[][]{{"1", "3", "4", "4"}, {"6", "3", "4", "4"}, {"1", "3", "4", "4"}, {"1", "3", "4", "5"}};
                        break;
                }
                if (caseValue != 4) {
                    System.out.println("Сумма элементов: " + getArraySum(array));
                    System.out.println("_______________________________________________________________");
                }

            } catch (MyArraySizeException | MyArrayDataException e) {
                e.printStackTrace();
                System.out.println("_______________________________________________________________");
            }
        } while (caseValue != 4);
        System.out.println("Выход!");
    }

    private static int getCase() {
        System.out.println("Выберите проверку: 1 - MyArraySizeException, 2 - MyArrayDataException, 3 - посчитать сумму элементов, 4 - ВЫХОД");
        return new Scanner(System.in).nextInt();
    }

    private static int getArraySum(String[][] array) {
        int sum = 0;

        if (array.length != ARRAY_SIZE) {
            throw new MyArraySizeException("Размер массива задан неверно, ожидалось 4х4");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != ARRAY_SIZE) {
                throw new MyArraySizeException("Размер массива задан неверно, ожидалось 4х4");
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (isIntegerValue(array[i][j])) {
                    sum += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataException("Элемент в массиве с индексом [" + i + "][" + j + "], содержит неверные данные: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    private static boolean isIntegerValue(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

