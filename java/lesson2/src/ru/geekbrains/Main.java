package ru.geekbrains;

public class Main {

    private static final int size = 10000000;
    private static final int h = size / 2;
    private static float[] arr = new float[size];

    public static void main(String[] args) {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long time1 = Thread1(arr);
        long time2 =  Thread2(arr);


    }

    private static long  Thread1(float[] arr) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long  time1 = System.currentTimeMillis() - start;

        System.out.printf("однопоточное время: %d%n", time1);
        return time1;
    }

    private static long  Thread2(float[] arr) {
        float[] a = new float[h];
        float[] b = new float[h];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, a, 0, h);
        System.arraycopy(arr, h, b, 0, h);

        ThreadOne t1 = new ThreadOne("a", a);
        ThreadOne t2 = new ThreadOne("b", b);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = t1.getArr();
        b = t2.getArr();

        System.arraycopy(a, 0, arr, 0, h);
        System.arraycopy(b, 0, arr, a.length, b.length);

        long time2 = System.currentTimeMillis() - start;

        System.out.printf("многопоточное время: %d%n", time2);

        return time2;
    }

}
