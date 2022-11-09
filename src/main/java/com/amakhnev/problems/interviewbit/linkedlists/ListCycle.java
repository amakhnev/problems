package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class ListCycle {


    public static void main(String[] args) {

        ListNode a = ListNode.create(Arrays.asList(1,2,3,4,5));
        ListNode last = a;
        while(last.next!=null)
            last = last.next;

        last.next = a.next.next;
        System.out.println("Result = "+new ListCycle().detectCycle(a));

    }


    public ListNode detectCycle(ListNode a) {
        if (a==null || a.next==null){
            return null;
        }
        ListNode fast = a.next.next,slow = a;

        while (!slow.equals(fast)){
            if (fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        //here we have detected the loop. Now need to find beginning.

        // find cycle length first...
        int cycleSize =1;
        ListNode current = slow;
        while (current.next!=slow){
            current=current.next;
            cycleSize++;
        }

        // then find the node, which is staying in "length" position from the start, and second node would point on start itself
        ListNode left=a, right = a;
        while (cycleSize-->0){
            right=right.next;
        }
        //now move two pointers at same speed and they will meet at the beginning on the loop!
        while (left!=right){
            left=left.next;
            right=right.next;
        }

        return left;
    }
}
