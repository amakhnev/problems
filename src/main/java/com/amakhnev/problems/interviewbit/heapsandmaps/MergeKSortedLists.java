package com.amakhnev.problems.interviewbit.heapsandmaps;

import com.amakhnev.problems.interviewbit.linkedlists.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        System.out.println(new MergeKSortedLists().mergeKLists(new ArrayList<>(Arrays.asList(
                ListNode.create(Arrays.asList(1, 10, 20)), ListNode.create(Arrays.asList(4, 11, 13)), ListNode.create(Arrays.asList(3, 8, 9, 9))
        ))));
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode fakeHead = new ListNode(0), prev = fakeHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        queue.addAll(a);

        while (queue.size() > 0) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.add(node.next);
            }
            node.next = null;
            prev.next = node;
            prev = node;
        }

        return fakeHead.next;
    }
}
