import java.util.Arrays;
import java.util.List;


public class RainWaterTrapped {

    public static void main(String[] args) {
        System.out.println("Result = " + new RainWaterTrapped().trap(
                Arrays.asList(0, -1, 0, -2, -1, 0, -1, -3, -2, -1, -2, -1)
        ));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int maxValue = Integer.MIN_VALUE, maxIdx = -1;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxValue) {
                maxValue = A.get(i);
                maxIdx = i;
            }
        }


        int total = 0, maxSoFar = Integer.MIN_VALUE;
        //traverse forward from beginning to maximum point
        for (int i = 0; i < maxIdx; i++) {
            maxSoFar = Math.max(maxSoFar, A.get(i));
            total += maxSoFar - A.get(i);
        }
        // traverse backward from end to maximum point
        maxSoFar = Integer.MIN_VALUE;
        for (int i = A.size() - 1; i > maxIdx; i--) {
            maxSoFar = Math.max(maxSoFar, A.get(i));
            total += maxSoFar - A.get(i);
        }

        return total;
    }
}
