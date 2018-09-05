package com.cofancs;

import java.util.Arrays;

public class SortingAlgorithm {

    public static final String INPUT_ARRAY_SHOULDN_T_BE_NULL = "inputArray shouldn't be null";
    public static final String INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS = "Input can contains digits and a single \"-\" characters! ";
    public static final String DASH = "-";

    public  String[] sortNullsToTheEnd(String[] inputArray){
        checkCorrectInput(inputArray);
        String[] result = new String[inputArray.length];
        doSortingTheEmptyCharachters(inputArray, result);
        return result;
    }

    private void doSortingTheEmptyCharachters(String[] inputArray, String[] result) {
        int index=0;
        int fromBack=result.length-1;
        for(int i=0;i<inputArray.length;i++){
            if(inputArray[i].equals(DASH)){
                result[fromBack]=inputArray[i];
                fromBack--;
            }else{
                result[index]=inputArray[i];
                index++;
            }
        }
    }

    private void checkCorrectInput(String[] inputArray) {
        checkIfNull(inputArray);
        checkIfTheElementsHasAnInvalidCharachter(inputArray);
    }

    private void checkIfTheElementsHasAnInvalidCharachter(String[] inputArray) {
        if(Arrays.stream(inputArray).anyMatch(s -> s.matches("^([0-9]+ | [-]])"))){
            throw new IllegalArgumentException(INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);
        }
    }

    private void checkIfNull(String[] inputArray) {
        if(inputArray == null){
            throw new IllegalArgumentException(INPUT_ARRAY_SHOULDN_T_BE_NULL);
        }
    }
}
