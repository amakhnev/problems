package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

/**
 * Need to sort in n*log(n) complexity with constant additional memory.
 * Solution is implementing mergesort and instead of recursion (which use log(n) extra space) use bottom to up approach -
 * sorting pairs, then 4 numbers, then 8,16,32,etc.
 */
public class SortList {

    public static void main(String[] args) {
        System.out.println("Result = "+ new SortList().sortList(
                ListNode.create(Arrays.asList(2,5,6,3,3,5,7))
        ));
    }


    public ListNode sortList(ListNode A) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next=A;

        int n = 0; // length of the list
        while (A!=null){
            n++;A=A.next;
        }

        ListNode prev,curr,left,right;
        for (int step=1;step<n;step<<=1){
            prev = fakeHead;
            curr = fakeHead.next; //start from the beginning
            while (curr!=null){
                left = curr;
                right = split(left,step);
                curr = split(right,step);
                prev = merge(left,right,prev);
            }
        }

        return fakeHead.next;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode last) {
        ListNode prev = last;
        while(left!=null && right!=null){
            if(left.val > right.val){
                prev.next = right;
                right = right.next;
            }
            else{
                prev.next = left;
                left = left.next;
            }
            prev = prev.next;
        }
        prev.next = (left!=null? left : right);
        while (prev.next!=null)
            prev = prev.next;
        return prev;
    }

    private ListNode split(ListNode node, int n) {
        if (node == null) return null;

        for(int i = 0; node.next!=null && i < n-1; i++) node = node.next; // stop on last node

        ListNode right = node.next;
        node.next=null;
        return right;
    }
}
