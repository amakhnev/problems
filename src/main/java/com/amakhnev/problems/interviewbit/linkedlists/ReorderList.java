package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class ReorderList {

    public static void main(String[] args) {

        System.out.println("Result = " + new ReorderList().reorderList(
                ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))
        ));
    }


    public ListNode reorderList(ListNode A) {
        ListNode fast = A, secondNode = A, last = null, secondHead = new ListNode(0);

        while (fast != null && fast.next != null) { // fast traverse to the end
            fast = fast.next.next;
            last = secondNode;
            secondNode = secondNode.next;
        }
        if (fast != null) { // number of nodes is odd, need to add one to the first half the list
            last = secondNode;
            secondNode = secondNode.next;
        }
        if (last != null) { // unlink first half from second
            last.next = null;
        }

        while (secondNode != null) { // invert second half
            ListNode temp = secondNode.next;
            secondNode.next = secondHead.next;
            secondHead.next = secondNode;
            secondNode = temp;
        }

        fast = A;
        secondNode = secondHead.next;
        while (secondNode != null) { // join two parts
            ListNode temp = secondNode.next;
            secondNode.next = fast.next;
            fast.next = secondNode;
            fast = secondNode.next;
            secondNode = temp;
        }

        return A;
    }

}
