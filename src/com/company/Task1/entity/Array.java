package com.company.Task1.entity;

import com.company.Task1.Exceptions.IndexOutOfBoundsException;
import com.company.Task1.tools.Scanners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import  java.util.Arrays;
import java.util.List;

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


      public int binarySearch(int item) {
            int first=0;
            int last=N-1;
            int position;
            int comparisonCount = 1;    // для подсчета количества сравнений

            // для начала найдем индекс среднего элемента массива
            position = (first + last) / 2;

            while ((arr[position] != item) && (first <= last)) {
                comparisonCount++;
                if (arr[position] > item) {  // если число заданного для поиска
                    last = position - 1; // уменьшаем позицию на 1.
                } else {
                    first = position + 1;    // иначе увеличиваем на 1
                }
                position = (first + last) / 2;
            }
            if (first <= last) {
               return this.arr[++position];
            } else {
                return 0;
            }
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

    private void swap(int a,int b){
    int temp=a;
        a=b;
        b=temp;
    }

    public void bubbleSort(){
    for (int i=N-1;i>0;i--){
        for (int j=1;j<i;j++){
            if (arr[j]>arr[j+1]){
                swap(arr[j],arr[j+1]);
            }
        }
    }
    }

    public  void quickSort( int low, int high) {
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
            // вызов рекурсии для сортировки левой и правой части
            if (low < j)
                quickSort( low, j);

            if (high > i)
                quickSort( i, high);
        }


    public void selectionSort(){
        for (int i=0;i<N;i++){
            int min=arr[i];
            int min_i=i;
            for (int j=i+1;j<N;j++){
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

    public List checkN(){
        int a = 0, b = 0, c = 0;
        List list=new ArrayList();
        for (int j = 0; j < N; j++)
            if ((arr[j] > 99) && (arr[j] < 1000)) {
                a = arr[j] / 10 / 10;
                b = arr[j] / 10 % 10;
                c = arr[j] % 100 % 10;
                if (b != a && c != a && c != b)
                    list.add(arr[j]);
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

    public List fib(){
        List arrayList=new ArrayList();
        int count=0;
        for (int i=0;i<N;i++){
            if (isPerfectSquare(5*arr[i]*arr[i]+4)||isPerfectSquare(5*arr[i]*arr[i]-4)) {
                arrayList.add(arr[i]);
                count++;
            }
        }
        if (count==0){
            System.out.println("nothing found");;
        }
        return arrayList;
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

    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                ", N=" + N +
                ", counter=" + counter +
                '}';
    }
}
