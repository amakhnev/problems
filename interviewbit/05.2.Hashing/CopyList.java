import java.util.HashMap;

public class CopyList {

    public static void main(String[] args) {
        CopyList _this = new CopyList();
        RandomListNode one = _this.new RandomListNode(1);
        RandomListNode two = _this.new RandomListNode(2);
        RandomListNode three = _this.new RandomListNode(3);
        one.next = two;
        two.next = three;
        one.random = three;
        two.random = one;
        three.random = one;

        RandomListNode copy = _this.copyRandomList(one);
        while (copy != null) {
            System.out.print(copy.label);
            copy = copy.next;
            if (copy != null) {
                System.out.print(" -> ");
            }
        }

    }


    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> values = new HashMap<>();
        RandomListNode curr = head;
        while (curr != null) {
            values.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.next != null)
                values.get(curr).next = values.get(curr.next);
            if (curr.random != null)
                values.get(curr).random = values.get(curr.random);
            curr = curr.next;
        }


        return values.get(head);
    }


    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
