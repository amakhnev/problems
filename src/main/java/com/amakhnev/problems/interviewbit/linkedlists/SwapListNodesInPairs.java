package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class SwapListNodesInPairs {

    public static void main(String[] args) {

        System.out.println("Result = " + new SwapListNodesInPairs().swapPairs(
                ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        ));
    }

    public ListNode swapPairs(ListNode A) {
        ListNode tempHead = new ListNode(0), iterator = tempHead;
        tempHead.next = A;
        while (iterator.next != null && iterator.next.next != null) {
            // current head represents end of swapped list, hence switching second and third nodes
            ListNode temp = iterator.next.next; // node to switch
            iterator.next.next = temp.next;
            temp.next = iterator.next;
            iterator.next = temp;
            // moving iterator two positions forward
            iterator = iterator.next.next;
        }
        return tempHead.next;
    }
}
