package ru.geekbrains;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

import static ru.geekbrains.ChoicheSortArray.choicheSortArray;
import static ru.geekbrains.ElementToSearch.binaryFind;
import static ru.geekbrains.ElementToSearch.linerFind;
import static ru.geekbrains.InsertSortArray.inserSortArray;
import static ru.geekbrains.Timer.*;

public class Main {
    static long timerStart;
    static long timeRun;

    public static void main(String[] args){
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arraysCopy;

        Random rand = new Random();
        for (int i = 0; i < arrays.length; i++) {
            // arrays[i] = rand.nextInt(20);
        }
        timerStart =  System.nanoTime();
        arraysCopy = Arrays.copyOf(arrays, arrays.length);
        System.out.println("Вывод адреса массива " + arrays.toString());
        System.out.println("Вывод содержимого оригинального массива: " + Arrays.toString(arrays));
        System.out.println("Вывод содержимого скопированного массива: " + Arrays.toString(arraysCopy));
        System.out.println("Сравнение массивов " + Arrays.equals(arrays, arraysCopy));
        timeRun = System.nanoTime() - timerStart;;
        System.out.println("Время выполнения кода  составляет: " + timeRun + " нс");


        timerStart =  System.nanoTime();
        System.out.println(linerFind(arrays, 3));
        timeRun = System.nanoTime() - timerStart;;
        System.out.println("Время выполнения линейного поиска  составляет: " + timeRun + " нс");
        timerStart =  System.nanoTime();
        System.out.println(binaryFind(arrays, 3));
        timeRun = System.nanoTime() - timerStart;;
        System.out.println("Время выполнения двоичного поиска  составляет: " + timeRun + " нс");

        int[] arrays400Elements = new int[400];
        int[] arrays400ElementsCopy;
        int[] arrays400ElementsCopyChoiche;
        int[] arrays400ElementsCopyInsert;
        for (int i = 0; i < arrays400Elements.length; i++) {
            arrays400Elements[i] = rand.nextInt(1000);
        }
        arrays400ElementsCopy = Arrays.copyOf(arrays400Elements, arrays400Elements.length);
        arrays400ElementsCopyChoiche = Arrays.copyOf(arrays400Elements, arrays400Elements.length);
        arrays400ElementsCopyInsert = Arrays.copyOf(arrays400Elements, arrays400Elements.length);

        long timerStartSort = System.nanoTime();
        Arrays.sort(arrays400Elements);
        System.out.println(Arrays.toString(arrays400Elements));
        long timerEndSort = System.nanoTime();
        long timerSort = timerEndSort - timerStartSort;
        System.out.println("Время выполнения кода в нс: " + timerSort);

        BubbleSortArray array = new BubbleSortArray(arrays400ElementsCopy.length);
        for (int i = 0; i < arrays400Elements.length; i++) {
            array.into(arrays400ElementsCopy[i]);
        }
        System.out.println("Вывод неотсортированного массива: ");
        array.printer();
        System.out.println("Вывод отсортированного массива методом пузырьковой сортировки: ");
        long timerStartBurble = System.nanoTime();
        array.bubbleSorted();
        array.printer();
        long timerEndBurble = System.nanoTime();
        long timerBurble = (timerEndBurble - timerStartBurble);
        System.out.println("Время выполнения кода в нс: " + timerBurble);

        System.out.println("Вывод неотсортированного массива: ");
        System.out.println(Arrays.toString(arrays400ElementsCopyChoiche));
        System.out.println("Вывод отсортированного массива методом выбора: ");
        long timerStartChoiche = System.nanoTime();
        choicheSortArray(arrays400ElementsCopyChoiche);
        long timerEndChoiche = System.nanoTime();
        long timerChoiche = (timerEndChoiche - timerStartChoiche);
        System.out.println("Время выполнения кода в нс: " + timerChoiche);

        System.out.println("Вывод неотсортированного массива: ");
        System.out.println(Arrays.toString(arrays400ElementsCopyInsert));
        System.out.println("Вывод отсортированного массива методом вставки: ");
        long timerStartInsert = System.nanoTime();
        inserSortArray(arrays400ElementsCopyInsert);
        long timerEndInsert = System.nanoTime();
        long timerInsert = (timerEndInsert - timerStartInsert);
        System.out.println("Время выполнения кода в нс: " + timerInsert);

        long[] arrayComparison = {timerSort, timerBurble, timerChoiche, timerInsert};
        Arrays.sort(arrayComparison);
        System.out.println(Arrays.toString(arrayComparison));

    }


}
