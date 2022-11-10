package com.amakhnev.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddTwoNumbersTest {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    public void whenZeroAddedToZero_thenShouldReturnZero() {
        AddTwoNumbers.ListNode zeroOne = addTwoNumbers.longToListNode(0);
        AddTwoNumbers.ListNode zeroTwo = addTwoNumbers.longToListNode(0);

        assertThat("Zero plus zero should be zero", addTwoNumbers.listNodeToLong(addTwoNumbers.addTwoNumbers(zeroOne, zeroTwo)) == 0);
    }


    @Test
    public void whenZeroAddedToSomething_thenShouldReturnSomething() {

        long SOMETHING = 2345l;
        AddTwoNumbers.ListNode zero = addTwoNumbers.longToListNode(0);
        AddTwoNumbers.ListNode something = addTwoNumbers.longToListNode(SOMETHING);

        assertThat("Something plus zero should be something", addTwoNumbers.listNodeToLong(addTwoNumbers.addTwoNumbers(zero, something)) == SOMETHING);
    }

}
