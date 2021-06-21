package com.company.Task2.services;

import com.company.Task2.comparators.MaxValueComparator;
import com.company.Task2.comparators.MinValueComparator;
import com.company.Task2.comparators.ValueSumComparator;
import com.company.Task2.valiadator.JaggedArrayValidation;

import java.util.Comparator;

public class Services {
    private final JaggedArrayValidation jaggedArrayValidation=new JaggedArrayValidation();

   public void maxValueSort(int[][] array){
       sort(array,new MaxValueComparator());
   }

    public void minValueSort(int[][] array){
        sort(array,new MinValueComparator());
    }

    public void sumValueSort(int[][] array){
        sort(array,new ValueSumComparator());

    }


    private void sort(int[][] jaggedArray, Comparator<Object> comparator){

        if (!jaggedArrayValidation.validate(jaggedArray)){
            return;
        }

        for (int i = jaggedArray.length-1;i>0;--i){
            for (int j = 0;j < i;++j){
               if (comparator.compare(jaggedArray[j], jaggedArray[j + 1]) > 0){
                swap(jaggedArray,j,j+1);
               }
            }
        }
    }


    private void swap(int[][] jaggedArray,int i,int j){
        int[] temp=jaggedArray[i];
        jaggedArray[i]=jaggedArray[j];
        jaggedArray[j]=temp;
    }

}
