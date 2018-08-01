import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        Set<ListNode> nodes = new HashSet<>(); // quick solution to detect cycle. Needs extra space though.
        ListNode temp = this;
        while (temp!=null&&!nodes.contains(temp)){
            nodes.add(temp);
            sb.append(temp.val);
            if (temp.next!=null){
                sb.append(" -> ");
            }
            temp = temp.next;
        }
        if (temp!=null){
            sb.append(temp.val+" (cycle)");
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
