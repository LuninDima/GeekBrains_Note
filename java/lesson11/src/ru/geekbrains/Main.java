package ru.geekbrains;

import static com.sun.tools.javac.jvm.ByteCodes.swap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] arrays = {"Начало", "Конец"};
        ExchangeArrayElements.ExchangeArrayElements(arrays, 0,1);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }




        String[] array = {"Generics", ", ", "Hello"};
        Cat cat2 = new Cat("рыжик");
        Cat cat3 = new Cat("олег");
        Cat[] cat = {cat2};


        System.out.print("Исходный массив: ");
        for (Cat item : cat) {

        }
        System.out.println();

/*        ArrayModifier.elementsSwap(cat, 0, 1);
        for (Cat item : cat) {


        }*/

        System.out.println(Arrays.toString(cat));





/*       ExchangeArrayElements<Integer> arrayElements = new ExchangeArrayElements<Integer>(1, 2, 3, 4);
        swap(arrayElements, 5, 5);*/

    }

/*    public static void swap(ExchangeArrayElements<Integer> arr, int n1, int n2){
        System.out.println("Task1: "+Arrays.toString(arr));
        Object sw = ExchangeArrayElements<Integer>(1);
        arr[n1]=arr[n2];
        arr[n2]=sw;
        System.out.println("The result of the replacement: "+Arrays.toString(arr)+"\n================================");
    }*/
}
