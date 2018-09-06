package com.cofancs;

import java.util.Arrays;

public class SortingAlgorithm {

    public static final String INPUT_ARRAY_SHOULDN_T_BE_NULL = "inputArray shouldn't be null";
    public static final String INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS = "Input can contains digits and a single \"-\" characters! ";
    public static final String DASH = "-";

    public  String[] sortNullsToTheEnd(String[] inputArray){
        checkCorrectInput(inputArray);
        String[] result =doSortingTheEmptyCharacters(inputArray);
        return result;
    }

    private String[] doSortingTheEmptyCharacters(String[] inputArray) {
        for(int i=0;i<inputArray.length-1;i++){
            if(inputArray[i].equals(DASH)){
                String element=inputArray[i];
                for(int j = i+1; j<inputArray.length;j++){
                    if(!inputArray[j].equals(DASH)){
                        inputArray[i]=inputArray[j];
                        inputArray[j]=element;
                        break;
                    }
                }

            }

        }
        return inputArray;
    }

    private void checkCorrectInput(String[] inputArray) {
        checkIfNull(inputArray);
        checkIfTheElementsHasAnInvalidCharacter(inputArray);
    }

    private void checkIfTheElementsHasAnInvalidCharacter(String[] inputArray) {
        if(Arrays.stream(inputArray).anyMatch(s -> s.matches("^([0-9]+ | [-])"))){
            throw new IllegalArgumentException(INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);
        }
    }

    private void checkIfNull(String[] inputArray) {
        if(inputArray == null){
            throw new IllegalArgumentException(INPUT_ARRAY_SHOULDN_T_BE_NULL);
        }
    }
}
