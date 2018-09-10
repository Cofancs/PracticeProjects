package com.cofancs;

import java.util.Arrays;

public class SortingAlgorithm {

    public static final String INPUT_ARRAY_SHOULDN_T_BE_NULL = "inputArray shouldn't be null";
    public static final String INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS = "Input can contains digits and a single \"-\" characters! ";
    public static final String DASH = "-";
    public static final Character DASH_CHAR = '-';

    private static boolean testIfContainsInvalidObjects(Object object) {
        return !((object == null) || (object instanceof Integer) || ((object instanceof Character) && object.equals(DASH_CHAR)) || ((object instanceof String) && object.equals(DASH)));
    }

    public Object[] checkInputThenSortEmptyToTheEnd(Object[] inputArray) throws IllegalArgumentException {
        checkCorrectInput(inputArray);
        return sortEmptyToTheEnd(inputArray);
    }

    private void checkCorrectInput(Object[] inputArray) {
        checkIfNull(inputArray);
        checkIfTheElementsHasAnInvalidCharacter(inputArray);
    }

    private void checkIfTheElementsHasAnInvalidCharacter(Object[] inputArray) throws IllegalArgumentException {
        Arrays.stream(inputArray).filter(
                SortingAlgorithm::testIfContainsInvalidObjects)
                .forEach(object -> {
                    throw new IllegalArgumentException(INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);
                });
    }

    private void checkIfNull(Object[] inputArray) throws IllegalArgumentException {
        if (inputArray == null || inputArray.length <= 0) {
            throw new IllegalArgumentException(INPUT_ARRAY_SHOULDN_T_BE_NULL);
        }
    }

    private Object[] sortEmptyToTheEnd(Object[] inputArray) {
        loopThroughElementsToSort(inputArray);
        return inputArray;
    }

    private void loopThroughElementsToSort(Object[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            whenEmptyCheckForNextElementThenExchange(inputArray, i);
        }
    }

    private void whenEmptyCheckForNextElementThenExchange(Object[] inputArray, int i) {
        if (isEmptyValue(inputArray[i])) {
            inputArray[i] = null;
            loopThroughFollowingElementsToExchangeValue(inputArray, i);
        }
    }

    private void loopThroughFollowingElementsToExchangeValue(Object[] inputArray, int i) {
        for (int j = i + 1; j < inputArray.length; j++) {
            if (exchangeValuesWhenNextIsNumber(inputArray, i, j)) break;
        }
    }

    private boolean exchangeValuesWhenNextIsNumber(Object[] inputArray, int i, int j) {
        if (!(isEmptyValue(inputArray[j]))) {
            inputArray[i] = inputArray[j];
            inputArray[j] = null;
            return true;
        }
        return false;
    }

    private boolean isEmptyValue(Object o) {
        return o == null || o.equals(DASH) || o.equals(DASH_CHAR);
    }


}
