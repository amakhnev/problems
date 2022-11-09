package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class ReverseLinkListII {


    public static void main(String[] args) {
        System.out.println("Result = "+ new ReverseLinkListII().reverseBetween(
                ListNode.create(Arrays.asList(1,2,3,4,5,6,7,8,9,10)),4,10
        ));

    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        int counter = 1;
        ListNode midHead = new ListNode(0), iterator = A, lastLeft = null, lastMid = null;

        while (iterator != null) {
            ListNode next = iterator.next;
            if (counter < B) { // saving last position of left non reversed part
                lastLeft = iterator;
            } else if (counter <= C) {
                if (lastMid == null) { // saving first position on mid reversed part
                    lastMid = iterator;
                }
                iterator.next = midHead.next;
                midHead.next = iterator;
            } else {
                break;
            }
            iterator = next;
            counter++;
        }
        if (lastLeft != null) { // attache left non reversed part to reversed mid
            lastLeft.next = midHead.next;
        } else { // no left part, just assign result to first mid node
            A = midHead.next;
        }
        if (iterator != null) { // attach right non reversed part
            lastMid.next = iterator;
        }
        return A;
    }
}
