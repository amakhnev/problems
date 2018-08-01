import java.util.Arrays;

public class AddTwoNumbersAsLists {

    public static void main(String[] args) {
        ListNode a = ListNode.create(Arrays.asList(6, 7, 8));
        ListNode b = ListNode.create(Arrays.asList(1));

        System.out.println("Result = " + new AddTwoNumbersAsLists().addTwoNumbers(a, b));
    }


    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode resultHead = new ListNode(0), prev = resultHead;
        int carry = 0;
        while (A != null || B != null) {
            int sum = carry + (A != null ? A.val : 0) + (B != null ? B.val : 0);
            ListNode current = new ListNode(sum % 10);
            prev.next = current;
            prev = current;
            carry = sum / 10;
            if (A != null) {
                A = A.next;
            }
            if (B != null) {
                B = B.next;
            }
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return resultHead.next;
    }

}




