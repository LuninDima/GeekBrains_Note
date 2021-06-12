package ru.geekbrains;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 10, false);
        Cat[] arrayCat = new Cat[5];
        arrayCat[0] = new Cat("Barsik", 10, false);
        arrayCat[1] = new Cat("Ivan", 10, false);
        arrayCat[2] = new Cat("Dima", 10, false);
        arrayCat[3] = new Cat("Oleg", 10, false);
        arrayCat[4] = new Cat("Danil", 10, false);

        Plate plate = new Plate(addFoodConsole());
        for (int i = 0; i < arrayCat.length; i++) {
            if (!arrayCat[i].satiety) {
                if (plate.food >= arrayCat[i].appetite) {
                    arrayCat[i].eat(plate);
                    System.out.print(arrayCat[i].name + " поел. ");
                    plate.info();
                } else
                    System.out.println("В тарелке недостаточно еды, чтобы покормить кота " + arrayCat[i].name + " Необходимо " + cat.appetite + " , а в тарелке: " + plate.food);
            } else System.out.println("Кот уже сыт");
        }


    }

    public static int addFoodConsole() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите количество еды, которое нужно добавить в тарелку:");
        int addFood = console.nextInt();
        return addFood;
    }
}
