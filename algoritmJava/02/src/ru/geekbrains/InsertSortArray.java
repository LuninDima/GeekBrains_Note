package ru.geekbrains;

import java.util.Arrays;

public class InsertSortArray {
    public static void inserSortArray(int arr[]) {
        int in;
        int buff;
        for (int i = 1; i < arr.length; i++) {
            buff = arr[i];
            in = i;
            while (in > 0 && arr[in - 1] >= buff) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = buff;
        }
        System.out.println(Arrays.toString(arr));
    }
}
