import java.util.Arrays;

public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {
        System.out.println("Result = " + new RemoveNthNodeFromListEnd().removeNthFromEnd(ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 2));
    }


    public ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null || B <= 0) {
            return A;
        }
        ListNode iterator = A, prev = null, curr = A;
        int counter = 0;
        while (counter < B && iterator != null) {
            iterator = iterator.next;
            counter++;
        }
        if (iterator == null) { // N more or equal than length of list, hence removing first node as per requirements
            return A.next;
        }

        while (iterator != null) {
            prev = curr;
            curr = curr.next;
            iterator = iterator.next;
        }

        // curr will be Nth element from the end, so delete it
        prev.next = curr.next;
        return A;
    }
}
