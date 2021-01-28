package com.gb.adudarev.leeson4;

import java.util.Arrays;
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
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        //printMap();
        while (true) {
            map[0][0] = DOT_X;
            map[1][0] = DOT_X;
            map[1][1] = DOT_X;
            map[2][3] = DOT_X;
            map[3][2] = DOT_X;
            map[4][4] = DOT_X;
            printMap();
            checkWin(DOT_EMPTY);
        }

    /*    while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");*/
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symbol) {

            for (int i = 0; i < map.length; i++) {
                boolean res = true;
                for (int j = 1; j < map.length && res; j++)
                    res = map[j][i] == map[0][i];
                if (res)
                    return true;
            }
            return false;
        }


    public static boolean checkWinColumn(char symbol) {
        for (int i = 0; i < map.length; i++) {
            int lineCount = 0;
            for (int j = 0; j < map.length - 1; j++) {
                if (map[j][i] == symbol && map[j + 1][i] == symbol) {
                    lineCount++;
                }
                if (lineCount == DOTS_TO_WIN - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkWinRows(char symbol) {
        for (int i = 0; i < map.length; i++) {
            int lineCount = 0;
            for (int j = 0; j < map.length - 1; j++) {
                if (map[i][j] == symbol && map[i][j + 1] == symbol) {
                    lineCount++;
                }
                if (lineCount == DOTS_TO_WIN - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static Random rand = new Random();

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            if (i != 0) {
                System.out.print(i + " ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


