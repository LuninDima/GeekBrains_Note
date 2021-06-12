package ru.geekbrains;

public class User {
    private int id;
    private String name;
    private int age;
    private String position;

    public User(int id, String name, int age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
    }
    public void info(){
        System.out.println("id: " + id + "; Имя пользователя: " + name+ "; Должность: " + position + "; Возраст: " + age);
    }
    public void changePosition(String position){
        this.position = position;
        System.out.println("Пользователь " + name + " Получил новую должность " + position);
    }
}
