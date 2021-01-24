package com.gb.adudarev.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainClassLesson3 {
    public static void main(String[] args) {

        System.out.println("Урок 3. Практика. Задание #1");
        int min = 0;
        int max = 10;
        String helloText = " Приветствую тебя мой дорогой друг! ";
        String ruleText = " Сейчас тебе предстоит сыграть со мной в увлекательную и" +
                " очень интересную игру \"Отгадай число от " + min + " до " + max + "\" ";
        String dangerText = " Но помни, у тебя всего 3 попытки. Удачи! ";
        System.out.println(getPrettyFooter(new String[]{helloText, ruleText, dangerText}));
        // guessTheNumberGame(min, max);

        System.out.println("\nУрок 3. Практика. Задание #2");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String helloText2 = " Приветствую тебя мой дорогой друг! ";
        String ruleText2 = " Сейчас тебе предстоит сыграть со мной в увлекательную и" +
                " очень интересную игру \"Отгадай слово\" ";
        String dangerText2 = " Я загадываю слово, ты угадываешь, все просто. Удачи! ";
        System.out.println(getPrettyFooter(new String[]{helloText2, ruleText2, dangerText2}));
        guessTheWordGame(words);
    }

    private static void guessTheWordGame(String[] words) {
        String userWorld;
        String specialSymbol = "#";
        String secretString = "###############";
        Scanner sc = new Scanner(System.in);
        String guessedWord = getRandomWordFromArray(getRandomNumber(words.length), words);
        System.out.println(guessedWord);
        do {
            String finalStr = "";
            System.out.println(">> Пожалуста введи слово и нажми клавишу \"Enter\"");
            userWorld = sc.next().toLowerCase();
            int maxLength = getWordsDiffLength(userWorld, guessedWord);
            for (int i = 0; i < maxLength; i++) {
                if (userWorld.charAt(i) == guessedWord.charAt(i)) {
                    finalStr += String.valueOf(guessedWord.charAt(i));
                } else {
                    finalStr += specialSymbol;
                }
            }
            if (!userWorld.equals(guessedWord)) {
                System.out.println("Не угадал, попробуй еще раз!\n" + finalStr + secretString);
            }

        } while (!userWorld.equals(guessedWord));
        System.out.println(getPrettyFooter(new String[]{" Поздравляю, ты угадал слово \"" + guessedWord + "\" !!! "}));
        System.out.println(getPrettyFooter(new String[]{" >>> Игра закончена! <<< "}));
        sc.close();
    }

    private static int getWordsDiffLength(String userWorld, String guessedWord) {
        return userWorld.length() < guessedWord.length() ? userWorld.length() : guessedWord.length();
    }

    private static String getRandomWordFromArray(int number, String[] words) {
        return words[number];
    }


    private static void guessTheNumberGame(int min, int max) {

        do {
            int randomNumber = getRandomNumber(max);
            for (int i = 2; i >= 0; i--) {
                if (randomNumber == getScannerNumber(min, max)) {
                    System.out.println(getPrettyFooter(new String[]{">>> Поздравляю ты угадал число, молодец!!! <<<"}));
                    break;
                } else if (i != 0) {
                    System.out.println("Не угадал. Осталось " + (i) + " попытки.\n");
                } else {
                    System.out.println(getPrettyFooter(new String[]{" >>> Ты проиграл :( <<<"}));
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет.");
        } while (new Scanner(System.in).nextInt() == 1);
        System.out.println(getPrettyFooter(new String[]{">>> Игра закончена! <<<"}));
    }

    private static int getScannerNumber(int min, int max) {
        int inputNumber;
        do {
            System.out.println(">> Пожалуста введи число от " + min + " до " + max + " и нажми клавишу \"Enter\"");
            inputNumber = new Scanner(System.in).nextInt();
        } while (inputNumber < min || inputNumber > max);
        return inputNumber;
    }

    private static int getRandomNumber(int randomNumber) {
        return new Random().nextInt(randomNumber);
    }

    private static String getPrettyFooter(String[] arrayStr) {
        String specialSymbol = "-";
        String lineStr = "";
        String lineSymbol = "|";
        String spaceSymbol = " ";
        String finalText = "";
        int maxValue = arrayStr[0].length();
        for (int i = 0; i < arrayStr.length; i++) {

            if (maxValue < arrayStr[i].length()) {
                maxValue = arrayStr[i].length();
            }
        }
        lineStr = lineStr + " ";
        for (int i = 0; i < maxValue; i++) {
            lineStr = lineStr + specialSymbol;
        }

        for (int i = 0; i < arrayStr.length; i++) {

            finalText += lineSymbol + arrayStr[i];
            for (int j = 0; j < maxValue - arrayStr[i].length(); j++) {
                finalText = finalText + spaceSymbol;
            }
            finalText = finalText + lineSymbol + "\n";

        }
        lineStr = lineStr + "\n";
        finalText = lineStr + finalText + lineStr;

        return finalText;
    }
}
