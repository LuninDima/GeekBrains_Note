package ru.geekbrains;

public class Dog extends Animal{

    public Dog(String name, int distanceRun, int distanceSwim) {
        super(name, distanceRun, distanceSwim);
    }

    @Override
    void run() {
           if(distanceRun <= 500){
               System.out.println(name + " Пробежал " + distanceRun);
        } else {
               System.out.println("Ошибка, собака не может пробежать больше 500 метров");
           }
    }
    @Override
    void swim(){
        if (distanceSwim <= 10){
            System.out.println(name + " проплыл " + distanceSwim);
        } else {
            System.out.println("Ошибка, собака не может проплыть больше 10 метров");
        }
    }
}
