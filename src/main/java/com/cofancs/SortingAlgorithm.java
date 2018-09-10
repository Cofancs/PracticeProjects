package com.cofancs;

import java.util.Arrays;

public class SortingAlgorithm {

    public static final String INPUT_ARRAY_SHOULDN_T_BE_NULL = "inputArray shouldn't be null";
    public static final String INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS = "Input can contains digits and a single \"-\" characters! ";
    public static final String DASH = "-";

    public String[] checkInputAndSortEmptyToTheEnd(String[] inputArray) {
        checkCorrectInput(inputArray);
        return sortEmptyToTheEnd(inputArray);
    }

    private String[] sortEmptyToTheEnd(String[] inputArray) {
        loopElementsThenSort(inputArray);
        return inputArray;
    }

    private void loopElementsThenSort(String[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            checkIfDashThenExchangeValueIfFollowingIsNumber(inputArray, i);
        }
    }

    private void checkIfDashThenExchangeValueIfFollowingIsNumber(String[] inputArray, int i) {
        if (inputArray[i].equals(DASH)) {
            loopThroughTheFollowingElementsForExchangeValue(inputArray, i);
        }
    }

    private void loopThroughTheFollowingElementsForExchangeValue(String[] inputArray, int i) {
        for (int j = i + 1; j < inputArray.length; j++) {
            if (exchangeTwoElementsPlace(inputArray, i, j)) break;
        }
    }

    private boolean exchangeTwoElementsPlace(String[] inputArray, int i, int j) {
        String element = inputArray[i];
        if (!inputArray[j].equals(DASH)) {
            inputArray[i] = inputArray[j];
            inputArray[j] = element;
            return true;
        }
        return false;
    }

    private void checkCorrectInput(String[] inputArray) {
        checkIfNull(inputArray);
        checkIfTheElementsHasAnInvalidCharacter(inputArray);
    }

    private void checkIfTheElementsHasAnInvalidCharacter(String[] inputArray) {
        if (Arrays.stream(inputArray).anyMatch(s -> s.matches("^([0-9]+ | [-])"))) {
            throw new IllegalArgumentException(INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);
        }
    }

    private void checkIfNull(String[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException(INPUT_ARRAY_SHOULDN_T_BE_NULL);
        }
    }
}
