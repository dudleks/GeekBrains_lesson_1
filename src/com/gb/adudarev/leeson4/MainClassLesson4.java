package com.gb.adudarev.leeson4;

import java.util.Random;
import java.util.Scanner;

public class MainClassLesson4 {

    /*
        Домашнее задание
        Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
        Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
        * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    */
    public static char[][] mainArray;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 5;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();


    public static void main(String[] args) {
        initArray();
        printArray();

        while (true) {
            humanTurn();
            printArray();
            if (checkWinner(DOT_X)) {
                System.out.println("Поздравляю вы победили!");
                break;
            }
            if (isArrayFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printArray();
            if (checkWinner(DOT_O)) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (isArrayFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    private static boolean checkWinner(char symbol) {
        int endOffset = mainArray.length - DOTS_TO_WIN;

        for (int rowOffset = 0; rowOffset <= endOffset; rowOffset++) {

            if (checkWinDiagonals(symbol, rowOffset)) {
                return true;
            }

            for (int columnOffset = 0; columnOffset <= endOffset; columnOffset++) {

                if (checkWinLines(symbol, rowOffset, columnOffset)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isArrayFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mainArray[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWinLines(char symbol, int rowOffset, int columnOffset) {
        int rowCounter = 0;
        int columnCounter = 0;

        int rowArrayLength = rowOffset + DOTS_TO_WIN;
        int columnArrayLength = columnOffset + DOTS_TO_WIN;

        for (int rowLine = rowOffset; rowLine < rowArrayLength; rowLine++) {
            for (int columnLine = 0; columnLine < columnArrayLength; columnLine++) {
                if (mainArray[rowLine][columnLine] == symbol) {
                    rowCounter++;
                } else {
                    rowCounter = 0;
                }

                if (mainArray[columnLine][rowLine] == symbol) {
                    columnCounter++;
                } else {
                    columnCounter = 0;
                }
            }
            if (columnCounter == DOTS_TO_WIN || rowCounter == DOTS_TO_WIN)
                return true;
        }
        return false;
    }

    public static boolean checkWinDiagonals(char symbol, int rowOffset) {
        int lrDiagonalCounter = 0;
        int rlDiagonalCounte = 0;

        int rowArrayLength = DOTS_TO_WIN + rowOffset;

        for (int rowLine = rowOffset; rowLine < rowArrayLength; rowLine++) {
            if (mainArray[rowLine][rowLine] == symbol) {
                lrDiagonalCounter++;
            } else {
                lrDiagonalCounter = 0;
            }

            if (mainArray[rowLine][mainArray.length - rowLine - 1] == symbol) {
                rlDiagonalCounte++;
            } else {
                rlDiagonalCounte = 0;
            }
            if (rlDiagonalCounte == DOTS_TO_WIN || lrDiagonalCounter == DOTS_TO_WIN)
                return true;
        }
        return false;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        mainArray[y][x] = DOT_O;
    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        mainArray[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (mainArray[x][y] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static void initArray() {
        mainArray = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mainArray[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printArray() {
        for (int i = 0; i <= SIZE; i++) {
            if (i != 0) {
                System.out.print(i + " ");
            } else {
                System.out.print("  ");
            }
        }

        System.out.println();
        String specialSymbol = " ";
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + specialSymbol);

            for (int j = 0; j < SIZE; j++) {
                System.out.print(mainArray[i][j] + specialSymbol);
            }
            System.out.println();
        }
        System.out.println();
    }
}


