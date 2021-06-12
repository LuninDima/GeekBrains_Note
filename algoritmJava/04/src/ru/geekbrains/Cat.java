package ru.geekbrains;


public class Cat {
    private String name;
    private int age;
    private int number;


    public Cat(int number, String name, int age) {
        this.name = name;
        this.age = age;
        this.number = number;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void info() {
        System.out.println("Порядковый номер кота: " + number);
        System.out.println("Имя кота: " + name);
        System.out.println("Возраст кота: " + age);
    }


}
