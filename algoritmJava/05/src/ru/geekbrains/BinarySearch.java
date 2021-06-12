package ru.geekbrains;

public class BinarySearch {
    public static int binarySearch(int array[], int searchElement) {
        int mid;
        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (firstIndex <= lastIndex) {
            mid = (firstIndex + lastIndex) / 2;
            if (searchElement == array[mid]) {
                return mid;
            } else if (array[mid] < searchElement) {
                firstIndex++;
            } else if (array[mid] > searchElement) {
                lastIndex--;
            }
        }
        return -1;
    }
}

