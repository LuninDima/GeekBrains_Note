package ru.geekbrains;

public class Timer {
   public static long timerStart(){
       long timerStart = System.nanoTime();
       return timerStart;
    }
    public static long timerEnd(){
        long timerEnd = System.nanoTime();
        return timerEnd;
    }
    public static void timer(){
        System.out.println(timerEnd());
        System.out.println(timerStart());
        long timeRun = timerStart() - timerEnd();
        System.out.println("Время выполнения кода: " + timeRun);
    }
}
