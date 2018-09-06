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
        Object[] inputArray= {4,"-",8,"-","-",3};
        Object[] result=underTest.sortNullsToTheEnd(inputArray);
        Object[] expected = {4,8,3,null,null,null};
        assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("╯°□°）╯already in correct order")
    public void sortNullsToTheEndThatIsAlreadyInCorrectOrder(){
        Object[] inputArray= {4,8,3,"-","-","-"};
        Object[] result=underTest.sortNullsToTheEnd(inputArray);
        Object[] expected = {4,8,3,null,null,null};
        assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("╯°□°）╯2")
    public void sortNullsToTheEndShouldReturnCorrectOrderForAnotherInput(){
        Object[] inputArray= {4,5,"-","-","-",8,"-","-",3};
        Object[] result=underTest.sortNullsToTheEnd(inputArray);
        Object[] expected = {4,5,8,3,null,null,null,null,null};
        assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("╯°□°）╯-----")
    public void sortNullsToTheEndShouldReturnCorrectOrderForInputWhereAreOnlyEmptyElements(){
        Object[] inputArray= {"-",'-',"-","-","-","-","-","-","-"};
        Object[] result=underTest.sortNullsToTheEnd(inputArray);
        Object[] expected = {null,null,null,null,null,null,null,null,null};
        assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("╯°□°）╯12324534")
    public void sortNullsToTheEndShouldReturnCorrectOrderForInputWhereAreOnlyNumbersElements(){
        Object[] inputArray= {1,2,4,8,9,6,2,5,4,7,8,5};
        Object[] result=underTest.sortNullsToTheEnd(inputArray);
        Object[] expected = {1,2,4,8,9,6,2,5,4,7,8,5};
        assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("╯°□°）╯'EMPTY'")
    public void sortNullsToTheEndThrowsExceptionForEmptyArray(){
        Object[] inputArray= {};
        assertThrows(IllegalArgumentException.class,()->{underTest.sortNullsToTheEnd(inputArray);},SortingAlgorithm.INPUT_ARRAY_SHOULDN_T_BE_NULL);
    }
    @Test
    @DisplayName("╯°□°）╯'abc'")
    public void sortNullsToTheEndThrowsExceptionForNotCorrectInputABC(){
        Object[] inputArray= {"-",'-',4,"bf"};
        assertThrows(IllegalArgumentException.class,()->{underTest.sortNullsToTheEnd(inputArray);},SortingAlgorithm.INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);
    }

    @Test
    @DisplayName("╯°□°）╯'abc2'")
    public void sortNullsToTheEndThrowsExceptionForNotCorrectInputDoubleDash(){
        Object[] inputArray= {43,4,"--","-"};
        assertThrows(IllegalArgumentException.class,()->{underTest.sortNullsToTheEnd(inputArray);},SortingAlgorithm.INPUT_CAN_CONTAINS_DIGITS_AND_A_SINGLE_CHARACTERS);
    }

    @Test
    @DisplayName("╯°□°）╯everything")
    public void sortNullsToTheEndThrowsExceptionForCorrectInputWithNullsAndDashesAndNumbers(){
        Object[] inputArray= {1,null,4,'-',9,"-",2,'-',4,null,8,5};
        Object[] result=underTest.sortNullsToTheEnd(inputArray);
        Object[] expected = {1,4,9,2,4,8,5,null,null,null,null,null};
        assertArrayEquals(expected,result);
    }
}
