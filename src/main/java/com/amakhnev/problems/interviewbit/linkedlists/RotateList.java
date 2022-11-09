package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class RotateList {

    public static void main(String[] args) {
        System.out.println("Result = " + new RotateList().rotateRight(ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 41));
    }


    public ListNode rotateRight(ListNode A, int B) {
        if (A == null || B <= 0) {
            return A;
        }

        ListNode iterator = A, current = A, previous = null, last = null;
        int counter = 0;
        while (counter++ < B) {
            iterator = iterator.next!=null?iterator.next:A;
        }


        while (iterator != null) {
            last = iterator;
            previous = current;
            current = current.next!=null?current.next:A;
            iterator = iterator.next;
        }

        if (previous.next != null){ // need to reattach
            previous.next = null;
            last.next = A;
        }
        return current;
    }
}
