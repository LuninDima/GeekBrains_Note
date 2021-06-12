package ru.geekbrains;

public enum Fruit2 {
    January("Январь", 1), Febrary("Февраль", 2) , March("Март", 3);
    private String title;
    private int weight;

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    Fruit2(String title, int weight){
        this.title = title;
        this.weight = weight;
    }
}
