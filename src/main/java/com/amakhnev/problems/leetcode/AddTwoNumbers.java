package com.amakhnev.problems.leetcode;

public class AddTwoNumbers {
    //https://leetcode.com/problems/add-two-numbers/description/

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */


    public static void main(String[] args) {
        AddTwoNumbers _this = new AddTwoNumbers();
        ListNode l1 = _this.longToListNode(9);
        ListNode l2 = _this.longToListNode(9999999991L);
        _this.printListNode(l1);
        _this.printListNode(l2);
        _this.printListNode(_this.addTwoNumbers(l1, l2));

        _this.printListNode(_this.addTwoNumbers(_this.longToListNode(342), _this.longToListNode(465)));

    }

    protected void printListNode(ListNode l) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        while (l != null) {
            sb.append(l.val);
            if (l.next != null) {
                sb.append(" -> ");
            }
            l = l.next;
        }
        sb.append(")");
        System.out.println(sb.toString());
    }

    protected ListNode longToListNode(long a) {
        if (a == 0) {
            return new ListNode(0);
        }
        ListNode first = null, prev = null, current;

        while (a > 0) {
            current = new ListNode((int) (a % 10));
            if (first == null) {
                first = current;
            }
            if (prev != null) {
                prev.next = current;
            }
            a /= 10;
            prev = current;
        }
        return first;
    }

    protected long listNodeToLong(ListNode l) {
        long result = 0, pow = 1;
        while (l != null) {
            result += l.val * pow;
            pow *= 10;
            l = l.next;
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode first = null, prev = null, current, p1=l1,p2=l2;
        int extra = 0;
        while (p1 != null || p2 != null || extra > 0) {
            int newVal = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + extra;
            extra = newVal / 10;
            current = new ListNode(newVal % 10);
            if (first == null) {
                first = current;
            }
            if (prev != null) {
                prev.next = current;
            }

            if (p1 != null) {
                p1 = p1.next;
            }

            if (p2 != null) {
                p2 = p2.next;
            }

            prev = current;
        }

        return first;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
