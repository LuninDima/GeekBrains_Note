package ru.geekbrains;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    /*
    Задание 4.1
    На основе данных объектного списка из задания 3.4 реализуйте
    простой стек и его базовые методы.
    Оцените время выполнения операций с помощью базового метода
    System.nanoTime().
    Задание 4.2
    На основе данных объектного списка из задания 3.4 реализуйте
    простую очередь и его базовые методы.
    Реализуйте вспомогательные методы.
    Оцените время выполнения операций с помощью базового метода
    System.nanoTime().
    Задание 4.3
    На основе данных объектного списка из задания 3.4 реализуйте
    простой дек и его базовые методы.
    Оцените время выполнения операций с помощью базового метода
    System.nanoTime().
    Задание 4.4
    Реализуйте приоритетную очередь на основе ссылочных типов данных,
    например, integer.
    Оцените время выполнения операций с помощью базового метода
    System.nanoTime().
    Задание 4.5
    На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на
    базе связанного списка.
    Оцените время выполнения операций с помощью базового метода
    System.nanoTime().
     */
    private static long startTimer;
    private static long timeRun;

    public static void main(String[] args) {

        Cat[] cats = new Cat[14];
        String[] name = {"Барсик", "Вадим", "Иван", "Олег", "Саша", "Даша", "Маша", "Барсик", "Вадим", "Иван", "Олег", "Саша", "Даша", "Маша"};
        int[] age = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] numberCats = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        System.out.println("Task 4.1");

        // создаем объектный связанный список котов
        LinkedList<Cat> catLinkedList = new LinkedList<>();
        for (int i = 0; i < name.length; i++) {
            catLinkedList.add(i, new Cat(numberCats[i], name[i], age[i]));
        }
        // выводим в консоль содержимое объектного связанного списка котов
        for (Cat number : catLinkedList) {
            number.info();
        }
        // создаем стек на основе объектного связанного списка котов
        startTimer = System.nanoTime();
        Stack<Cat> catStack = new Stack<>();
        for (Cat number : catLinkedList) {
            catStack.push(number);
        }
        //выводим в консоль верхний элемент стека
        catStack.peek().info();
        // освобождаем стек и выводим его в консоль
        while (!catStack.empty()) {
            catStack.pop().info();
        }
        // проверяем пуст ли стек
        System.out.println(catStack.empty());
        timeRun = System.nanoTime() - startTimer;
        System.out.println("Время выполнения кодв в нс: " + timeRun);

        System.out.println("TASK 4.2");
        startTimer = System.nanoTime();
        Queue<Cat> catQueue = new LinkedList<>();
        for (Cat number : catLinkedList) {
            catQueue.add(number);
        }
        System.out.println("Размер очереди: " + catQueue.size());
        System.out.println(catQueue.isEmpty());
        catQueue.remove();
        catQueue.peek().info();
        while ((!catQueue.isEmpty())) {
            catQueue.poll().info();
        }
        timeRun = System.nanoTime() - startTimer;
        System.out.println("Время выполнения кодв в нс: " + timeRun);

        System.out.println("TASK 4.3");

        startTimer = System.nanoTime();
        Deque<Cat> catDeque = new ArrayDeque<>();
        catDeque.add(new Cat(3, "Рыжик", 3));
        catDeque.add(new Cat(2, "<Барсик>", 3));
        catDeque.addLast(new Cat(4, "Васька", 3));
        catDeque.addFirst(new Cat(1, "Олег", 3));
        catDeque.addFirst(new Cat(1, "Олег", 3));
        catDeque.removeFirst();
        catDeque.removeLast();
        catDeque.pollFirst().info();
        catDeque.pollLast().info();
        timeRun = System.nanoTime() - startTimer;
        System.out.println("Время выполнения кодв в нс: " + timeRun);

        System.out.println("TASK 4.4");

        startTimer = System.nanoTime();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(6);
        priorityQueue.add(8);
        priorityQueue.add(10);
        priorityQueue.offer(5);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());

        }
        timeRun = System.nanoTime() - startTimer;
        System.out.println("Время выполнения кодв в нс: " + timeRun);

        System.out.println("TASK 4.5");

        LinkedList<Cat> catLinkedList2 = new LinkedList<>();
        for (int i = 0; i < name.length; i++) {
            catLinkedList2.add(i, new Cat(numberCats[i], name[i], age[i]));
        }
        for (Cat number : catLinkedList2) {
            number.info();
        }
        startTimer = System.nanoTime();
        Stack<Cat> catStack2 = new Stack<>();
        for (Cat number : catLinkedList2) {
            catStack2.push(number);
            while (!catStack2.empty()) {
                catStack2.pop().info();
            }
            timeRun = System.nanoTime() - startTimer;
            System.out.println("Время выполнения кодв в нс: " + timeRun);

            startTimer = System.nanoTime();
            Queue<Cat> catQueue2 = new LinkedList<>();
            for (Cat number2 : catLinkedList2) {
                catQueue2.add(number2);
            }
            while ((!catQueue2.isEmpty())) {
                catQueue2.poll().info();
            }
            timeRun = System.nanoTime() - startTimer;
            System.out.println("Время выполнения кодв в нс: " + timeRun);
        }
    }
}
