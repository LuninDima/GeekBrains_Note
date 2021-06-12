package ru.geekbrains;

import java.util.*;

/*
Задание 3.1
На основе массива из домашнего задания 2.1 реализуйте простой
список и коллекцию.
Оцените время выполнения преобразования.
Задание 3.2
На основе списка из задания 3.1 реализуйте основные методы
добавления, удаления и получения объекта или элемента из списка.
Оценить выполненные методы с помощью базового класса
System.nanoTime().
Задание 3.3
Реализуйте простой односвязный список и его базовые методы.
Задание 3.4
На основе списка из задания 3.1 реализуйте простой двусторонний
список и его базовые методы.
Реализуйте список заполненный объектами из вашего класса из задания
1.3
Задание 3.5
Реализуйте итератор на основе связанных списков из задания 3.4 и
выполните базовые операции итератора.
Оцените время выполнения операций с помощью базового метода
System.nanoTime()
 */

public class Main {
    static long timerStart;
    static long timerRun;

    public static void main(String[] args) {
        Cat[] cats = new Cat[14];
        String[] name = {"Барсик", "Вадим", "Иван", "Олег", "Саша", "Даша", "Маша", "Барсик", "Вадим", "Иван", "Олег", "Саша", "Даша", "Маша"};
        int[] age = {1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(i + 1, name[i], age[i]);
            cats[i].info();
        }
        System.out.println("Task3.1");

            timerStart = System.nanoTime();
            ArrayList<String> catsList = new ArrayList<>();
            for (int i = 0; i < cats.length; i++) {
                catsList.add(i, cats[i].getName());
            }
            System.out.println(catsList);

            ArrayList<Cat> catsCollection = new ArrayList<>();

            for (int i = 0; i < cats.length; i++) {
                catsCollection.add(i, cats[i]);
                System.out.println(catsCollection);
            }
            System.out.println(catsCollection);
            for (Cat number : catsCollection) {
                number.info();
            }
            timerRun = System.nanoTime() - timerStart;
            System.out.println("Время выполнения кода в нс: " + timerRun);

        System.out.println("Task3.2");

            timerStart = System.nanoTime();
            catsList.add(14, "Кот");
            System.out.println(catsList.get(14));
            catsList.remove(14);
            System.out.println(catsList.get(0));
            timerRun = System.nanoTime() - timerStart;
            System.out.println("Время выполнения кода в нс: " + timerRun);

        System.out.println("Task3.3");

            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add("второй");
            linkedList.addFirst("первый");
            linkedList.add("третий");
            linkedList.addLast("четвертый");

            System.out.println(linkedList);
            System.out.println(linkedList.get(2));
            System.out.println(linkedList.getFirst());
            System.out.println(linkedList.getLast());
            System.out.println(linkedList.peekFirst());
            System.out.println(linkedList.peekLast());
            System.out.println(linkedList.pollFirst());
            System.out.println(linkedList.pollLast());
            System.out.println(linkedList);
            System.out.println(linkedList.contains("второй"));
            linkedList.remove(0);

        System.out.println("Task3.4");

            LinkedList<Cat> catLinkedList = new LinkedList<>();
            catLinkedList.addAll(0, catsCollection);
            catLinkedList.add(0, new Cat("Чижик", 3));
            catLinkedList.addFirst(new Cat("Котик", 2));
            catLinkedList.addLast(new Cat("Котик", 2));
            catLinkedList.remove(0);
            catLinkedList.set(0, cats[0]);
            System.out.println(catLinkedList.contains(cats[1]));
            cats[1] = catLinkedList.get(0);
            cats[1].info();
            for (Cat number : catLinkedList) {
                number.info();
            }

        System.out.println("Task3.4");
            timerStart = System.nanoTime();
            Iterator<Cat> catIterator = catLinkedList.iterator();
            Cat iter;
            while (catIterator.hasNext()){
                iter = catIterator.next();
                iter.info();
                catIterator.remove();
            }
        ListIterator<Cat> catListIterator = catLinkedList.listIterator();
            while (catListIterator.hasNext()){
                catListIterator.next();
            }
            Cat iter2;
            catListIterator.add(cats[2]);
            catListIterator.add(new Cat(3,"Дог",3));

            while (catListIterator.hasPrevious()) {

                iter2 = catListIterator.previous();
                iter2.info();
                catListIterator.set(new Cat(3, "Васька",4));
            }
            for (Cat number: catLinkedList){

                number.info();
            }
            timerRun = System.nanoTime() - timerStart;
            System.out.println("Время выполнения кода:  " + timerRun);

    }


}
