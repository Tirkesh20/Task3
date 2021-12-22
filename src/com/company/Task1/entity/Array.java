package com.company.Task1.entity;

import com.company.Task1.exceptions.IndexOutOfBoundsException;
import com.company.Task1.tool.Scanners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import  java.util.Arrays;

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



    public Array(int... values){
        N=values.length;
        arr=Arrays.copyOf(values,N);
        counter=N;
    }

    public void add(int index,int value) throws IndexOutOfBoundsException {
        if (index>N){
            throw new IndexOutOfBoundsException("index is out of range");
        }
        arr[index]=value;
    }

    public void add(int value){
        if (this.counter>=this.N) {
            int[] array = Arrays.copyOf(arr,N*2);
            array[counter]=value;
            counter++;
            arr=array;
        }else {
            arr[counter] = value;
            counter++;
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


    public void consoleFilling(){
        for (int i=0;i<N;i++){
        arr[i]= Scanners.intScanner();
        }
    }

    public void fillingFromFile(String fileLocation) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(fileLocation));
        String[] split = input.readLine().split(" ");
        N=split.length;
        arr=new int[N];
        for (int i = 0; i < split.length; i++)
        {
            arr[i] = Integer.parseInt(split[i]);
        }

    }

    public void randomFill(int randomRange){
        for(int i = 0; i < N; i++) {
         //элементу массива присваивается случайное
             arr[i] = (int)(Math.random() * randomRange);
         }
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

    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                ", N=" + N +
                ", counter=" + counter +
                '}';
    }
}
