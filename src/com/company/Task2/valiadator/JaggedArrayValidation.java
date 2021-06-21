package com.company.Task2.valiadator;

public class JaggedArrayValidation {

    public boolean validate(int[][] jaggedArray){
        return jaggedArray != null
                && jaggedArray.length != 0
                && jaggedArray.length != 1;
    }
}
