package com.company.Task1.service;


import org.junit.Test;

import static junit.framework.TestCase.*;

public class ArraySearchServicesTest {
     int[] unsortedArray=new int[]{123,3,5,2,4,1,8,7,6,9};
    int[] nullArray=null;
    int[] emptyArray=new int[0];

   private final SearchService searchServices =new DefaultSearchServices();


    @Test
    public void testFibonacciFunctionWhenArrayIsNull(){
        testFibonacciFunction(null,nullArray);
    }

    @Test
    public void testFibonacciFunctionWhenArrayLengthIsZero(){
        testFibonacciFunction(null,emptyArray);
    }


    private void testFibonacciFunction(int[] expected,int[] array){
        int[] actual= searchServices.fib(array);
        assertEquals(expected,actual);
    }


    @Test
    public void testFindUniqueThreeDigitNumbers_WhenNoUniqueNumber(){
        assertEquals(null, searchServices.findUniqueThreeDigitNumber(unsortedArray));
    }
    @Test
    public void testFindUniqueThreeDigitNumbers_WhenThereUniqueNumber(){
        assertTrue(searchServices.findUniqueThreeDigitNumber(unsortedArray).contains(123));
    }

    @Test
    public void testFindUniqueThreeDigitNumbers_WhenArrayIsEmpty(){
        assertEquals(null, searchServices.findUniqueThreeDigitNumber(unsortedArray));
    }

    @Test
    public void testFindPrimeNumbersWhenArrayIsNull(){
        findPrimeNumbers(nullArray,nullArray);
    }

    private void findPrimeNumbers(int[] expected,int[] array){
        int[] actual= searchServices.getPrimeNumbers(array);
        assertEquals(expected,actual);
    }





}