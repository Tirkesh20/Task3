package com.company.Task1.services;

import java.util.ArrayList;
import java.util.List;

public class Services {


    private static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }

    public static List checkN(int[] arr){
        int a = 0, b = 0, c = 0;
        List list=new ArrayList();
        for (int i : arr)
            if ((i > 99) && (i < 1000)) {
                a = i / 10 / 10;
                b = i / 10 % 10;
                c = i % 100 % 10;
                if (b != a && c != a && c != b)
                    list.add(i);
            }
        if (!list.isEmpty()){
            return list;
        }
        return null;
    }

    public  void quickSort( int[] arr,int low, int high) {
        if (arr.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int base = arr[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < base) {
                i++;
            }

            while (arr[j] > base) {
                j--;
            }

            if (i <= j) {//меняем местами
                swap(arr[i],arr[j]);
                i++;
                j--;
            }

        }
        if (low < j)
            quickSort(arr,low, j);

        if (high > i)
            quickSort(arr,i,high);
    }

    public  static void bubbleSort(int[] arr){
    for (int i=arr.length-1;i>0;i--){
        for (int j=1;j<i;j++){
            if (arr[j]>arr[j+1]){
                swap(arr[j],arr[j+1]);
            }
        }
    }
}

    private boolean isPerfectSquare(int num){
        int n=(int) Math.sqrt(num);
        return (n*n==num);
    }

    public static void selectionSort(int[] arr){
        for (int i=0;i< arr.length;i++){
            int min=arr[i];
            int min_i=i;
            for (int j=i+1;j< arr.length;j++){
                if ((arr[j]<min)){
                    min=arr[j];
                    min_i=j;
                }
            }
            if (i!=min_i){
                swap(arr[i],arr[min_i]);
            }
        }
    }


    private static boolean isPrime(int value){
        return value % 2 != 0;
    }

    public static int[] getPrimeNumbers(int[] arr){
        int[] primeNumbers=new int[arr.length];
        int counter=0;
        for (int j : arr) {
            if (isPrime(j)) {
                primeNumbers[counter] = j;
                counter++;
            }
        }
        return primeNumbers;
    }

    public List fib(int[] arr){
        List arrayList=new ArrayList();
        int count=0;
        for (int j : arr) {
            if (isPerfectSquare(5 * j * j + 4) || isPerfectSquare(5 * j * j - 4)) {
                arrayList.add(j);
                count++;
            }
        }
        if (count==0){
            return null;
        }
        return arrayList;
    }

}
