package ru.geekbrains;

public class Cat {
    private String name;
    private int distanceRun;
    private int jump;

    public Cat(String name, int distanceRun, int jump) {
        this.name = name;
        this.distanceRun = distanceRun;
        this.jump = jump;
    }

    public void Running() {
        Treadmill.Running(name, distanceRun);
        Wall.Jumping(name, jump);
    }

  //  public void Jumping(String name, int jumpHigh) {
   //     Wall.Jumping(name, jumpHigh);
   // }
}

