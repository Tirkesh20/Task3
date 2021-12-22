package com.company.Task1.service;

import java.util.List;

public interface SearchService {
    List<Integer> findUniqueThreeDigitNumber(int[] arr);
    int binarySearch(int[] array, int value, int low, int high);
    int[] getPrimeNumbers(int[] arr);
    int[] fib(int[] arr);
}
