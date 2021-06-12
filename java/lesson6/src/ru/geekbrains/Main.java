package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        Cat catBarsik = new Cat("Барсик", 100);
	Dog dogSharik = new Dog("Шарик", 600, 11);

 catBarsik.run();
 dogSharik.run();
 dogSharik.swim();
    }
}
