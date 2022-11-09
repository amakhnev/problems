package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        System.out.println("Result = " + new MergeTwoSortedLists().mergeTwoLists(
                ListNode.create(Arrays.asList(1, 1, 3, 7, 8)),
                ListNode.create(Arrays.asList(2, 2, 3, 4, 5))
        ));

    }


    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(0), temp = head;
        while (A != null || B != null) {
            if (A != null && (B == null || A.val < B.val)) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }
        return head.next;
    }
}
