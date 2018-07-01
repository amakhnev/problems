import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-1,1,-1,1,-3,4,-1,2,1,-5,4));

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
