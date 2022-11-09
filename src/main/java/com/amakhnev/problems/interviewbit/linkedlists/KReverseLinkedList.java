package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class KReverseLinkedList {


    public static void main(String[] args) {

        System.out.println("Result = " + new KReverseLinkedList().reverseList(
                ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)), 3
        ));
    }

    public ListNode reverseList(ListNode A, int B) {
        ListNode fakeHead = new ListNode(0), last = null, prev = null, iterator = A;
        int counter = 0;
        while (iterator != null) {
            ListNode nextNode = iterator.next;
            counter++;
            if (last == null) {
                last = iterator;
            }
            iterator.next = fakeHead.next;
            fakeHead.next = iterator;

            if (counter % B == 0) { // reattach list
                if (prev != null) {
                    prev.next = fakeHead.next;
                } else {
                    A = fakeHead.next;
                }
                prev = last;
                last = null;
                fakeHead.next = null;
            }
            iterator = nextNode;
        }

        return A;
    }
}
