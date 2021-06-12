package ru.geekbrains;

public class Worker {


    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Worker(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }




    public String infoWorker(){
        return "ФИО: " + name + '\n' + " Должность: " + position + '\n' + " email: " + email + '\n' + " телефон: " + phoneNumber + '\n' + " Зарплата: " + salary + '\n' + " Возраст: " + age;

    }


}
