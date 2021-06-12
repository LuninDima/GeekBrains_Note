package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        gameGuessTheNumber();
        scanner.close();
    }

    public static void gameGuessTheNumber() {

        Random random = new Random();
        int randomNumber;
        int randomNumberMax = 3;
        int userAttempt = 3;
        int userNumber;
        String GameIf = "угадайте число от 0 до 9. У вас есть 3 попытки";
        String WinMessage = "Поздравляем! вы Угадали!";
        String NumberLess = "Указанное вами число меньше загаданного";
        String NumberMore = "указанное вами число больше загаданного";
        String gameOver = "У Вас закончились попытки. Игра окончена";
        String isRepeatGameText = "Повторить игру еще раз? 1 – да / 0 – нет";
        int repeatAnswer = 1;
        while (repeatAnswer == 1) {
            randomNumber = random.nextInt(randomNumberMax);
            System.out.println(GameIf);
            for (int i = 1; i <= userAttempt; i++) {
                userNumber = scanner.nextInt();
                if (userNumber == randomNumber) {
                    System.out.println(WinMessage);
                    break;
                } else if (userNumber < randomNumber) {
                    System.out.println(NumberLess);
                } else if (userNumber > randomNumber) {
                    System.out.println(NumberMore);
                }
                if (i == userAttempt) {
                    System.out.println(gameOver);
                }

            }
            System.out.println(isRepeatGameText);
            repeatAnswer = scanner.nextInt();
        }

    }

}
