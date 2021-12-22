package com.company.Task1.service;

import com.company.Task1.tool.Util;

import java.util.ArrayList;
import java.util.List;

public class DefaultSearchServices implements SearchService{

    public  List<Integer> findUniqueThreeDigitNumber(int[] arr){
        int a ,b, c;
        List<Integer> list=new ArrayList<>();
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




    private boolean isPerfectSquare(int num){
        int n=(int) Math.sqrt(num);
        return (n*n==num);
    }

    private int searchForSingleElement(int[] array, int value, int index) {
        int resutl = -1;

        if (array[index] == value) {
            resutl = index;
        }
        return resutl;
    }

    public int binarySearch(int[] array, int value, int low, int high) {
        if (array==null||array.length==0){
            return 0;
        }

        if (low >= high) {
            return searchForSingleElement(array, low, value);
        }

        int middleIndex = (low + high) / 2;

        if (array[middleIndex] == value) {
            return middleIndex;

        } else if (array[middleIndex] > value) {
            return binarySearch(array, value, low, middleIndex - 1);
        } else {
            return binarySearch(array, value, middleIndex + 1, high);
        }
    }


    private  boolean isPrime(int value){
        return value % 2 != 0;
    }

    public  int[] getPrimeNumbers(int[] arr){
        if (arr==null){
            return null;
        }
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

    public int[] fib(int[] arr){
        if (arr==null){
            return null;
        }

        if (arr.length == 0){
            return null;
        }

        List<Integer> arrayList=new ArrayList<Integer>();

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
        return Util.listToArray(arrayList);
    }



}
