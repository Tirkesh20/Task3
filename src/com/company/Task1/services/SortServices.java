package com.company.Task1.services;

public class SortServices {

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void quickSort(int[] arr, int low, int high) {
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
                swap(arr[i], arr[j]);
                i++;
                j--;
            }

        }
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

    public void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr[j], arr[j + 1]);
                }
            }
        }
    }
}
