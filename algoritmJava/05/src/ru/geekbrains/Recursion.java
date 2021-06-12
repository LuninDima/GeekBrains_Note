package ru.geekbrains;

public class Recursion {
    public  static int infinitiRecursion(int n){
        System.out.println(n);
        return  infinitiRecursion(n - 1);
    }
    public static int recursion(int n){
        System.out.println(n);
        if(n == 1){
            return 1;
        }
        return recursion(n - 1);
    }
    public static int recursionBinarySearch(int searchKey, int low, int high, int[] array){
        int mid;
        mid = (low + high) / 2;
       if(low > high){
           return -1;
       }
        if(searchKey == array[mid]){
            return mid;
        }else if(array[mid] < searchKey){
            return recursionBinarySearch(searchKey, low + 1, high, array);
        } else
            return recursionBinarySearch(searchKey, low, high - 1,array);
    }
}
