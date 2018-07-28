import java.util.Arrays;
import java.util.Stack;

public class PalindromeList {


    public static void main(String[] args) {
        System.out.println("Result = " + new PalindromeList().lPalin(
                ListNode.create(Arrays.asList(1,2,3,2,3,2,1))
        ));
    }


    public int lPalin(ListNode A) {
        ListNode prev = null, curr = A, last = A;

        while (last != null && last.next != null) { // reverse first half of the list
            last = last.next.next;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (last != null) // size is odd, hence need to shift second half by 1
            curr = curr.next;

        while (prev != null) {
            if (prev.val != curr.val) {
                return 0;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return 1;
    }


}
