package com.company.Task1;

import java.util.Arrays;

public class Array {

private int[] arr;
private int N;
private int counter;

    public Array() {
        N = 1;
       arr=new int[N];
       counter=0;
    }

    public Array(int n) {
        N = n;
        arr=new int[N];
        counter=0;
    }

    public int[] addToArray(int index,int value) throws IndexOutOfBoundsException {
        if (index>N){
            throw new IndexOutOfBoundsException("index is out of range");
        }
        arr[index]=value;
        return arr;
    }

    public int [] addToArray(int value){
        if (this.counter>=this.N) {
            int[] array = Arrays.copyOf(arr,N*2);
            array[counter]=value;
            counter++;
            return array;
        }else {
            arr[counter] = value;
            counter++;
            return arr;
        }
    }

    public int getMax(){
        int max;
        max=arr[0];
        for (int i=0;i<N;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public int getMin(){
        int min;
        min=arr[0];
        for (int i=0;i<N;i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public int[] getPrimeNumbers(){
        int[] primeNumbers=new int[N];
        int counter=0;
        for (int i = 0;i<N;i++){
            if (isPrime(arr[i])){
                primeNumbers[counter]=arr[i];
                counter++;
            }
        }
        return primeNumbers;
    }

    public static boolean isPrime(int value){
        return value % 2 != 0;
    }

    @Override
    public int hashCode(){
        int result=21;
        result=5*result+Integer.hashCode(N);
        result=5*result+ Arrays.hashCode(arr);
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (this==o)return true;
        if (o==null||getClass()!=o.getClass()) return false;
        Array array=(Array) o;
        if (N!=array.N)return false;
        return counter == array.counter && Arrays.equals(arr, array.arr);
    }

}
