package com.company.Task2.comparators;


import java.util.Comparator;

public class ValueSumComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {

        if (!(o1 instanceof int[]) && !(o2 instanceof int[])){
            return -1;
        }

        int[] array1 = (int[]) o1;
        int[] array2 = (int[]) o2;

        if (sumOfRow(array1) > sumOfRow(array2)) {
            return 1;
        }else if (sumOfRow(array1)<sumOfRow(array2)){
            return -1;
        }

        return 0;
    }

    public int sumOfRow(int[] array){
        int sum=0;
        for (int index:array){
            sum+=index;
        }
        return sum;
    }
}
