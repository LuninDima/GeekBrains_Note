package ru.geekbrains;

public class Cat extends Animal{
String color;
int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void catInfo(){
        System.out.println(name + "цвет" + color);
    }

    @Override
    public String toString(){
        this.name = name;
        this.color = color;
        return name + " цвет " + color;
    }
    @Override
    public int hashCode(){
return name.hashCode() + age + 71;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat another = (Cat)o;
        return this.age == another.age && this.name.equals(another.name);
    }
}