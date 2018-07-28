import java.util.Arrays;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        System.out.println("Result = " + new RemoveDuplicatesFromSortedListII().deleteDuplicates(
                ListNode.create(Arrays.asList(1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6))
        ));
    }


    public ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A, prev = null;
        boolean hasDuplicates = false;
        while (temp != null) {
            if (temp.next != null && temp.val - temp.next.val == 0) { // found duplicate, remove it and set flag to remove original later
                temp.next = temp.next.next;
                hasDuplicates = true;
            } else {
                if (hasDuplicates) { // need to remove original
                    if (prev != null) { // repoint previous node to next available
                        prev.next = temp.next;
                    } else { // repoint head to next available
                        A = temp.next;
                    }
                } else {
                    prev = temp;
                }
                temp = temp.next;
                hasDuplicates = false;
            }
        }
        return A;
    }


}
