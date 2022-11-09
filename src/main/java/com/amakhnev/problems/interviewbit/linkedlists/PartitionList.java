package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class PartitionList {

    public static void main(String[] args) {

        System.out.println("Result = " + new PartitionList().partition(
                ListNode.create(Arrays.asList(1, 12, 8, 4, 5, 7, 4, 1, 9, 2, 11, 12)), 4
        ));
    }


    public ListNode partition(ListNode A, int B) {
        ListNode rightNodesHeader = new ListNode(0),leftNodesHeader = new ListNode(0),iterator = A,
                lastRight = rightNodesHeader,lastLeft = leftNodesHeader;
        while (iterator!=null){
            ListNode next =iterator.next;
            if (iterator.val>=B){
                lastRight.next=iterator;
                iterator.next=null;
                lastRight=iterator;
            }else{
                lastLeft.next=iterator;
                iterator.next=null;
                lastLeft = iterator;
            }
            iterator = next;
        }
        lastLeft.next=rightNodesHeader.next;
        return leftNodesHeader.next;
    }
}
