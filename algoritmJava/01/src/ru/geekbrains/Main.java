package ru.geekbrains;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] name = {"Барсик", "Вадим", "Иван", "Олег", "Саша", "Даша", "Маша","Барсик", "Вадим", "Иван", "Олег", "Саша", "Даша", "Маша"};
	int[] age = {1,2,3,4,5,6,7,1,2,3,4,5,6,7};
        String name1 = "Барсик";
        Cat[] cat = new Cat[14];
	int age1 = 3;
	String name2 = "Барсик";
	int age2 = 3;
        System.out.println("Список котов");
        for (int i = 0; i < cat.length; i++) {
            cat[i] = new Cat(name[i], age[i], i + 1);
             cat[i].info();
        }

        System.out.println("Сравнение котов");
        long start = System.nanoTime();
        for (int i = 0; i < cat.length; i++) {
            for (int j = 0; j < cat.length; j++) {
                if(cat[i].equals(cat[j])){
                    System.out.println("Кот номер: " + cat[i].getNumber() + " и Кот номер: " + cat[j].getNumber() + " одинаковые по кличке и возрасту" );
                } else {
                    System.out.println("Кот номер: " + cat[i].getNumber() + " и  Кот номер: " + cat[j].getNumber() + " разные по кличке и возрасту");
                }
                }
            }
      long finish =  System.nanoTime();
        long operatingTimeAlgoritm = finish - start;
        System.out.println("Время выполнения алгоритма сравнения котов, мс: " + operatingTimeAlgoritm / 1000000);
    }

}
