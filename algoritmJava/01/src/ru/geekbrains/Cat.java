package ru.geekbrains;

public class Cat {
    String name;
    int age;
    int number;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public Cat(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;

    }

    public void info(){
        System.out.println("Кот номер: " + number + ". Кличка: " + name + ". Возраст " + age);
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if ( !(obj instanceof Cat) )
            return false;

        Cat cat = (Cat) obj;

        return this.name == cat.name && this.age == cat.age;
    }
}
