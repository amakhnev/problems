import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while (temp!=null){
            sb.append(temp.val);
            if (temp.next!=null){
                sb.append(" -> ");
            }
            temp = temp.next;
        }
        return sb.toString();
    }


    public static ListNode create(List<Integer> a){
        if (a==null || a.size()==0){
            return null;
        }
        ListNode result = new ListNode(a.get(0)),temp=result;
        for (int i=1;i<a.size();i++){
            temp.next = new ListNode(a.get(i));
            temp = temp.next;
        }
        return result;
    }
}
