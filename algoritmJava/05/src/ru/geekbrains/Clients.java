package ru.geekbrains;

public class Clients {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clients(String name) {
        this.name = name;
    }
    public void infoClients(){
        System.out.println(name);
    }
}
