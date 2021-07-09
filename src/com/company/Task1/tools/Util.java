package com.company.Task1.tools;

import java.util.List;

public class Util {

    public static int[] listToArray(List<Integer> list){
        int array[]=new int[list.size()];

        for (int i=0;i<array.length;i++){
            array[i]= list.get(i);
        }
        return array;
    }
}
