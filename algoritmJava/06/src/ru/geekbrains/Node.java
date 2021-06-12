package ru.geekbrains;

public class Node {
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.println("id: " + person.id + "Имя:" + person.name + " возраст: " + person.age);
    }
}
