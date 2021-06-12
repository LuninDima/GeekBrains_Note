package ru.geekbrains;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Main {
/*
Задание 5.1
Приведите пример использования рекурсии.
Задание 5.2
Реализуйте простой пример бесконечной рекурсии и обычной рекурсии
с условием для выхода.
Задание 5.3
Приведите пример изображающий стек вызова и стек вызова с
рекурсией.
Задание 5.4
Реализуйте простой алгоритм использующий цикл и простой алгоритм
использующий рекурсию.
Оцените два алгоритма с помощью базового метода System.nanoTime().
Задание 5.5
Реализуйте алгоритм двоичного рекурсивного поиска на основе
массива из задания 2.1.
Оцените алгоритм двоичного рекурсивного поиска с помощью
базового метода System.nanoTime() и сравните с обычным двоичным
поиском.
Задание 5.6
На основе массива из задания 2.1 реализуйте алгоритм сортировки
слиянием.
Оцените алгоритм сортировки слиянием с помощью базового метода
System.nanoTime() и сравните с сортировкой методом sort().
 */
    public static void main(String[] args) {
        long timerStart;
        long timerCyrcle;
        long timerRecursion;
        long timerBinarySearch;
        long timerBinaryRecSearch;
        System.out.println("TASK 5.1");
        // Пример рекурсии: Матрешка в матрешке.
        System.out.println("TASK 5.2");
        // бесконечная рекурсия
        int n = 100;
        // обычная рекурсия
        Recursion.recursion(n);
        // бесконечная рекурсия
        Recursion.infinitiRecursion(100);

        System.out.println("TASK 5.3");
        Clients clients1 = new Clients("Клиент1");
        Clients clients2 = new Clients("Клиент2");
        Clients clients3 = new Clients("Клиент3");
        Clients clients4 = new Clients("Клиент4");
        Clients clients5 = new Clients("Клиент5");

        Stack<Clients> clientsStack = new Stack<>();
        clientsStack.add(clients1);
        clientsStack.add(clients2);
        clientsStack.add(clients3);
        clientsStack.add(clients4);
        clientsStack.add(clients5);

        MyRecursionStack.recursionStack(clientsStack);

        System.out.println("TASK 5.4");

        int number = 1000;
        timerStart = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            System.out.println(number);
            number--;
        }
        timerCyrcle = System.nanoTime() - timerStart;

        number = 1000;
        timerStart = System.nanoTime();
        Recursion.recursion(number);
        timerRecursion = System.nanoTime() - timerStart;
        System.out.println("Время выполнения цикла нс: " + timerCyrcle);
        System.out.println("Время выполнения рекурсии нс: " + timerRecursion);

        System.out.println("TASK 5.5");
        Random rand = new Random();
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        timerStart = System.nanoTime();
        System.out.println(Recursion.recursionBinarySearch(66, 0, array.length - 1, array));
        timerBinaryRecSearch = System.nanoTime() - timerStart;
        System.out.println(BinarySearch.binarySearch(array, 66));
        timerBinarySearch = System.nanoTime() - timerStart;
        System.out.println("Время выполнения кода двоичного поиска путем рекурсии нс: " + timerBinaryRecSearch);
        System.out.println("Время выполнения кода двоичного поиска нс: " + timerBinarySearch);

        System.out.println("TASK 5.6");
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(MergeSort.sortMerge(array)));
    }
}
