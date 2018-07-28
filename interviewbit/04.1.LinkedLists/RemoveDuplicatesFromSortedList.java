import java.util.Arrays;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        System.out.println("Result = " + new RemoveDuplicatesFromSortedList().deleteDuplicates(
                ListNode.create(Arrays.asList(1,2,2,2,3,4,5,5,5,6))
        ));
    }


    public ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        while(temp.next!=null){
            if (temp.val-temp.next.val==0){
                temp.next=temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return A;
    }
}
