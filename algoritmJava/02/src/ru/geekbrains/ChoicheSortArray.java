package ru.geekbrains;

import java.util.Arrays;

public class ChoicheSortArray {
    static void swap(int arr[], int firstIndex, int lastIndex) {
        int buffer = arr[firstIndex];
        arr[firstIndex] = arr[lastIndex];
        arr[lastIndex] = buffer;
    }

    public static void choicheSortArray(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        System.out.println(Arrays.toString(arr));
    }
}
