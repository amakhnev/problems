import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {

    public static void main(String[] args) {
        System.out.println(new LargestContinuousSequenceZeroSum().lszero(
                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, -1, 0, 1, -1))
        ));
    }


    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            sums.put(sum, i);
        }
        int maxI = 0, maxJ = 0, maxLength = 0;
        int newSum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sums.containsKey(newSum) && sums.get(newSum) >= i) {
                if (sums.get(newSum) + 1 - i > maxLength) {
                    maxI = i;
                    maxJ = sums.get(newSum) + 1;
                    maxLength = maxJ - maxI;
                }

            }
            newSum += A.get(i);
        }
        return new ArrayList<>(A.subList(maxI, maxJ));

    }
}
