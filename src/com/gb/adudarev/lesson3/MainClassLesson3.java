package com.gb.adudarev.lesson3;

import java.util.Arrays;
import java.util.Random;

public class MainClassLesson3 {
    public static void main(String[] args) {

        System.out.println("Урок 3. Правктика. Задание #1");

        guessTheNumberGame(0, 9);


        System.out.println("\nУрок 3. Правктика. Задание #2");

    }

    private static void guessTheNumberGame(int min, int max) {
        System.out.println(getFooterText(min, max));
        System.out.println(">> Пожалуста введи число от " + min + " до " + max + " и нажми клавишу \"Enter");
        Random random = new Random();
        System.out.println( random.nextInt(max));
    }

    private static String getFooterText(int min, int max) {
        String helloText = " Приветствую тебя мой дорогой друг! ";
        String ruleText = " Сейчас тебе предстоит сыграть со мной в увлекательную и" +
                " очень интересную игру \"Отгадай число от " + min + " до " + max + "\" ";
        String dangerText = " Но помни, у тебя всего 3 попытки. Удачи! ";
        String[] arrayStr = {helloText, ruleText, dangerText};

        return getPrettyFooter(arrayStr);
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
