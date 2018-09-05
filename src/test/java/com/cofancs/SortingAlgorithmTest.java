package com.cofancs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortingAlgorithmTest {


    SortingAlgorithm underTest = new SortingAlgorithm();

    @Test
    @DisplayName("╯°□°）╯")
    public void sortNullsToTheEndShouldReturnCorrectOrder(){
        String[] inputArray= {"4","-","8","-","-","3"};
        String[] result=underTest.sortNullsToTheEnd(inputArray);
        String[] expected = {"4","8","3","-","-","-",};
        assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("╯°□°）╯2")
    public void sortNullsToTheEndShouldReturnCorrectOrderForAnotherInput(){
        String[] inputArray= {"4","5","-","-","-","8","-","-","3"};
        String[] result=underTest.sortNullsToTheEnd(inputArray);
        String[] expected = {"4","5","8","3","-","-","-","-","-"};
        assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("╯°□°）╯'NULL'")
    public void sortNullsToTheEndThrowsExceptionForNull(){
        String[] inputArray= {};
        String[] result=underTest.sortNullsToTheEnd(inputArray);
        assertThrows(IllegalArgumentException.class,()->{throw new IllegalArgumentException(SortingAlgorithm.INPUT_ARRAY_SHOULDN_T_BE_NULL);});
    }
    @Test
    @DisplayName("╯°□°）╯'abc'")
    public void sortNullsToTheEndThrowsExceptionForNotCorrectInputABC(){
        String[] inputArray= {"4","-","bf"};
        underTest.sortNullsToTheEnd(inputArray);
        assertThrows(IllegalArgumentException.class,()->{throw new IllegalArgumentException(SortingAlgorithm.INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);});
    }

    @Test
    @DisplayName("╯°□°）╯'abc2'")
    public void sortNullsToTheEndThrowsExceptionForNotCorrectInputDoubleDash(){
        String[] inputArray= {"43","4","--","-"};
        underTest.sortNullsToTheEnd(inputArray);
        assertThrows(IllegalArgumentException.class,()->{throw new IllegalArgumentException(SortingAlgorithm.INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);});
    }
}
