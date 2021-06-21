package com.company.Task2.comparators;

import java.util.Comparator;

public class MaxValueComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {

        int[] array1=(int[]) o1;
        int[] array2=(int[]) o2;

        if (maxInRow(array1)>maxInRow(array2)){
           return 1;
        }else if (maxInRow(array1)<maxInRow(array2)) {
           return -1;
        }
        return 0;
    }

    public int maxInRow(int[] array){
        int max=array[0];

        for (int index:array){
            if (index>max){
                max=index;
            }
        }
        return max;
    }



}
