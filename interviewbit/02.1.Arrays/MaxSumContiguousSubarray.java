import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        a.add(-150);
//        a.add(1); a.add(-3);a.add(4); a.add(-1);
//        a.add(2); a.add(1);a.add(-5); a.add(4);

        System.out.println("Result = " + new MaxSumContiguousSubarray().maxSubArray(a));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {

        int newSum = A.get(0);
        int sum = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            newSum = Math.max(newSum + A.get(i), A.get(i));
            sum = Math.max(sum, newSum);
        }
        return sum;


    }

}
