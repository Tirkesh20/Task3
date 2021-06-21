package com.company.Task2.comparators;

import java.util.Comparator;

public class MinValueComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        int[] array1=(int[])o1;
        int[] array2=(int[]) o2;

        if (minInRow(array1)>minInRow(array2)){
            return 1;
        }else if (minInRow(array1)<minInRow(array2)) {
            return -1;
        }
        return 0;
    }

    public int minInRow(int[] array){
        int min=array[0];
        for (int index:array){
            if (index<min){
                min=index;
            }
        }
        return min;
    }
}
