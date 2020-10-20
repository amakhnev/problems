import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
* Problem link = https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
* Solution is to have a look if next element will increase the sum of current subarray   
* a) if element increases previous subarray sum - we just continue subarray 
* b) if element itself is bugger than previuos subarray + this element - that means we need to start new subarray, represented with this element
* Solution executes with O(n) time complexity , O(1) additional space complexity
*/
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
