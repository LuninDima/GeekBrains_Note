package ru.geekbrains;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> arrays = Arrays.asList(
                "Стул", "Табуретка", "Стол", "Шкаф", "Диван",
                "Кровать", "Стул", "Табуретка", "Шкаф", "Шкаф",
                "Кровать", "Стул", "Toyota", "Диван", "Шкаф",
                "Кровать", "Табуретка", "Стол", "Шкаф", "Диван"
        );

        Set<String> uniqueWord = new HashSet<String>(arrays);


        System.out.println(arrays.toString());
        System.out.println("Уникальные слова");
        System.out.println(uniqueWord.toString());
        System.out.println("Частота слов");
        for (String key : uniqueWord) {
            System.out.println(key + ": " + Collections.frequency(arrays, key));
        }


        System.out.println("справочник");
        Phonebook phonebook = new Phonebook();

        phonebook.add("Человек1", "2342342345");
        phonebook.add("Человек2", "53452345");
        phonebook.add("Человек3", "2345345");
        phonebook.add("Человек2", "6346");
        phonebook.add("Человек1", "456456");
        System.out.println("-----------------");

        System.out.println("Получаем номера");
        System.out.println("Человек1");
        System.out.println(phonebook.get("Человек1"));
        System.out.println("Человек2");
        System.out.println(phonebook.get("Человек2"));
        System.out.println("Человек3");
        System.out.println(phonebook.get("Человек3"));
        System.out.println("-----------------");

        System.out.println("Если отсутствует в записи");
        System.out.println("Человек4");
        System.out.println(phonebook.get("Человек4"));
        System.out.println("-----------------");

        System.out.println("Запись существующего номера");
        phonebook.add("Человек1", "2342342345");
        System.out.println("Человек1");
        System.out.println(phonebook.get("Человек1"));
    }
}
