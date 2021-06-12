package ru.geekbrains;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;

public class Main {
/*    Задания 6.1
    Приведите пример использования древовидной структуры.
            Задание 6.2
    Реализуйте класс узла дерева и базовый шаблон дерева с базовыми
    методами.
            Задание 6.3
    Реализуйте методы поиска и вставки узла в дерево.
    Задание 6.4
    Реализуйте базовые методы обхода дерева и метода дисплей.
    Реализуйте поиск максимума и минимума.
            Задание 6.5
    Реализуйте метод удаления узла и выполните оценку времени базовых
    методов дерева с помощью System.nanoTime().
    Задание 6.6
    Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной
    сортировки с реализацией бинарной пирамиды.
    Выполните оценку алгоритма пирамидальной сортировки с помощью
System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
    Задание 6.7
    Приведите пример сбалансированного дерева и его применения.*/
    public static void main(String[] args) {
        System.out.println("TASK 6.1");
        // Пример древовидной структуры - генеологическое древо.
        System.out.println("TASK 6.2-6.7");
        Tree theTree = new Tree();
        theTree.insert(new Person(4, "Иван3", 35));
        theTree.insert(new Person(2, "Иван2", 33));
        theTree.insert(new Person(3, "Иван5", 31));
        theTree.insert(new Person(5, "Иван1", 32));

        theTree.max().display();
        theTree.min().display();

        theTree.find(2 ).display();
        theTree.delete(2);
        System.out.println();
        theTree.displayTree();

        //Задание 6.6: алгоритм пирамидальной сортировки с реализацией бинарной пирамиды, время
        int[] arrayToSort;
        arrayToSort = new int[1000];
        Random rand = new Random();
        for (int i = 0; i<1000; i++) {
            arrayToSort[i] = rand.nextInt(1000);
        }
        System.out.println("New array created:");
        System.out.println(Arrays.toString(arrayToSort));

        HeapSort heap = new HeapSort();
        long startTimeHeapSort = System.nanoTime();
        heap.heapSort(arrayToSort);
        double elapsedNanosHeapSort  = (double) (System.nanoTime() - startTimeHeapSort)/1000000;
        System.out.println("Array sorted by heap sort: ");
        System.out.println(Arrays.toString(arrayToSort));
        System.out.println("\tTime elapsed: " + String.valueOf(elapsedNanosHeapSort) + " milliseconds\n");



        //Задание 6.7: пример сбалансированного дерева и его применения
        System.out.println("Пример сбалансированного дерева:\n" +
                "\t- Красно-чёрное дерево;\n" +
                "\t- АВЛ-дерево;\n" +
                "\t- TreeMap в Java реализован на основе красно-чёрных деревьев.\n");
    }
}
