package ru.geekbrains;

import java.sql.SQLOutput;

public class Cat extends Animal{

    public Cat(String name, int distanceRun) {
        super(name, distanceRun);
    }
    @Override
    void run(){
        if(distanceRun <= 200) {
            System.out.println(name + " Пробежал " + distanceRun);
        } else {
            System.out.println("Ошибка, кот не может пробежать больше 200 метров");
        }
    }

    @Override
    void swim(){
            System.out.println("Ошибка, кот не умеет плавать");
        }
    }

