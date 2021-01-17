package com.gb.adudarev.lesson2;

import java.util.Arrays;

//        Урок 2. Основные конструкции
public class MainClass {
    public static void main(String[] args) {

//  1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Урок 2. Основные конструкции. Задание #1");
        System.out.println(Arrays.toString(replaceArraySymbols(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));

//  2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("\nУрок 2. Основные конструкции. Задание #2");
        System.out.println(Arrays.toString(tofillArray((new int[8]), new int[]{0, 3, 6, 9, 12, 15, 18, 21})));

//  3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("\nУрок 2. Основные конструкции. Задание #3");
        System.out.println(Arrays.toString(replaceAndMultiplyArraySymbols(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1})));

//  4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("\nУрок 2. Основные конструкции. Задание #4");
        toFillArrayDiagonally(new int[10][10]);
//  5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("\nУрок 2. Основные конструкции. Задание #5");
        System.out.println(getMinAndMaxArrayValue(new int[]{23, 34, 56, 7987, 8, 12, 3, 98, 12, 32, 43, 54, 234, 564}));
//  6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        System.out.println("\nУрок 2. Основные конструкции. Задание #6");
        System.out.println(isSumLeftAndRightEquals(new int[]{1, 2, 4, 0, 5, 2}));
//  7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
//        Если выполнение задач вызывает трудности, можете обратиться к последней странице методического пособия. Для задач со * не нужно искать решение в интернете, иначе вы теряете весь смысл их выполнения.
        System.out.println("\nУрок 2. Основные конструкции. Задание #7");
        System.out.println(Arrays.toString(offsetArrayByN(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 3)));
    }

    private static int[] offsetArrayByN(int[] array, int offset) {
        int lastValue = 0;
        for (int i = 0; i < offset; i++) {
            lastValue = array[array.length - 1];
            int bufferValue = 0;
            int nextValue = 0;
            for (int j = 0; j < array.length - 1; j++) {
                if (j == 0) {
                    bufferValue = array[j + 1];
                    array[j + 1] = array[j];
                } else {
                    nextValue = array[j + 1];
                    array[j + 1] = bufferValue;
                    bufferValue = nextValue;
                }
                array[i] = lastValue;
            }

        }
        return array;
    }

    private static boolean isSumLeftAndRightEquals(int[] array) {
        int sumLeft = 0;
        for (int i = 0; i < array.length; i++) {
            int sumRight = 0;
            for (int j = 0; j < array.length; j++) {
                sumRight += array[j];
            }
            sumLeft += array[i];
            sumRight = sumRight - sumLeft;
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    private static String getMinAndMaxArrayValue(int[] array) {
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            }
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        return "Минимальное значение: " + minValue + "\nМаксимальное значение: " + maxValue;
    }

    private static void toFillArrayDiagonally(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || j + 1 == array.length - i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static int[] replaceAndMultiplyArraySymbols(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    private static int[] tofillArray(int[] newArray, int[] arrayWithEements) {
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arrayWithEements[i];
        }
        return newArray;
    }

    private static int[] replaceArraySymbols(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i];
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        return arr;
    }
}
