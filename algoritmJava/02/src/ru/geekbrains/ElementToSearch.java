package ru.geekbrains;


import java.util.Arrays;

public class ElementToSearch {

    static String linerFind(int arr[], int elementsToFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementsToFind) {
                return "Индекс искомого элемента: " + i;
            }
        }
        return "Элемент не найден";
    }

    static String binaryFind(int arr[], int elementsToFind) {

        Arrays.sort(arr);
        int firstIndex = arr[0];
        int lastIndex = arr.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elementsToFind) {
                return "Индекс искомого элемента:" + middleIndex;
            } else if (arr[middleIndex] < elementsToFind) {
                firstIndex = middleIndex + 1;
            } else if (arr[middleIndex] > elementsToFind) {
                lastIndex = middleIndex - 1;
            }
        }
        return "искомый элемент не найден";
    }

}
