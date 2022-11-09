package com.amakhnev.problems.interviewbit.linkedlists;

import java.util.Arrays;

public class InsertionSortList {

    public static void main(String[] args) {

        System.out.println("Result = " + new InsertionSortList().insertionSortList(
                ListNode.create(Arrays.asList(34, 12, 8, 4, 5, 7, 4, 1, 9, 2, 11, 12))
        ));
    }


    public ListNode insertionSortList(ListNode A) {
        ListNode sortedNodesHead = new ListNode(0),current,next,currentSorted, prevSorted;
        current= A.next;sortedNodesHead.next = A;A.next=null; // one element is sorted!

        while (current!=null){
            next = current.next;
            currentSorted = sortedNodesHead.next;
            prevSorted = sortedNodesHead;
            while (currentSorted!=null){
                if (current.val<=currentSorted.val){
                    prevSorted.next=current;
                    current.next=currentSorted;
                    break;
                }
                prevSorted=currentSorted;
                currentSorted=currentSorted.next;
            }
            if (currentSorted==null){ // add to the end
                prevSorted.next=current;
                current.next=null;
            }

            current=next;
        }
        return sortedNodesHead.next;
    }

}
