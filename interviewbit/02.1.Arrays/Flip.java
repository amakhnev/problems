import java.util.ArrayList;
import java.util.List;


public class Flip {


    public static void main(String[] args) {
        System.out.print("Result = "+new Flip().flip("10011101"));
    }

    public ArrayList<Integer> flip(String A) {
        if (A == null || A.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> array = new ArrayList<>();
        for (char ch : A.toCharArray()) {
            if (ch == '1') {
                array.add(-1);
            } else {
                array.add(1);
            }
        }
        return maxSubArray(array);
    }

    public ArrayList<Integer> maxSubArray(List<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>();


        int newSum = A.get(0);
        int sum = A.get(0);
        int minIdx = 0, minCurIdx = 0, maxIdx = 0;

        for (int i = 1; i < A.size(); i++) {

            if (newSum < 0) { // if current element is positive and previous subsum is negative - this is start of new subarray
                minCurIdx = i;
            }
            newSum = Math.max(newSum + A.get(i), A.get(i));

            if (newSum > sum) { // found new champion! this is from minCurIdx to current index!
                sum = newSum;
                minIdx = minCurIdx;
                maxIdx = i;
            }
        }
        if (sum > 0) {
            result.add(minIdx+1);
            result.add(maxIdx+1);
        }

        return result;
    }

}
