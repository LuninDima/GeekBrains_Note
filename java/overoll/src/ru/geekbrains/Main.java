package ru.geekbrains;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    Fruit2 fruit1 = Fruit2.January;
    String a = fruit1.getTitle();
    int b = fruit1.getWeight();
        System.out.println(a + b);
/*
    if(fruit1 == Fruit2.January){
        System.out.println("сейчас январь месяц");
        switch (fruit1) {
            case January:
                System.out.println("сейчас" + Fruit2.January + "месяц");
                break;
        }
    }
        for(Fruit2 fruit4 : Fruit2.values()) {
            System.out.printf("Средний вес фрукта %s составляет: %d ед.\n", fruit4.getTitle(), fruit4.getWeight() + fruit4.getWeight());
        }
*/

    /*        System.out.println(Fruit2.valueOf("", fruit1.getTitle(), fruit1.getWeight()));*/
    }


    }

