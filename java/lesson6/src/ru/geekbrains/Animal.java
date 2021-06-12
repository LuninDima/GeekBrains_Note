package ru.geekbrains;

public class Animal {
protected String name;
protected int distanceRun;
protected int distanceSwim;


public Animal(String name, int distanceRun, int distanceSwim){
    this.name = name;
    this.distanceRun = distanceRun;
    this.distanceSwim = distanceSwim;


}

    public Animal(String name, int distanceRun) {
        this.name = name;
        this.distanceRun = distanceRun;
    }

    void run(){
        System.out.println(name + " пробежал1 " + distanceRun);
    }
    void swim(){
        System.out.println(name + " проплыл " + distanceSwim);
    }
}
