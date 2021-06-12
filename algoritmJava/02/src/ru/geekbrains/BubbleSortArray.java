package ru.geekbrains;

public class BubbleSortArray {
    long[] array;
    int elems;

    public BubbleSortArray(int max) {
        array = new long[max];
        elems = 0;
    }

    public void into(long value) {
        array[elems] = value;
        elems++;
    }

    public void printer() {
        for (int i = 0; i < elems; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    private void toSwap(int first, int second) {
        long buffer = array[first];
        array[first] = array[second];
        array[second] = buffer;
    }

    public void bubbleSorted() {
        for (int i = elems - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    toSwap(j, j + 1);
                }
            }
        }
    }
}
