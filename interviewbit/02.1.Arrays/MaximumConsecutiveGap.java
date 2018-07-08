import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumConsecutiveGap {


    public static void main(String[] args) {
        System.out.println("Result = " + new MaximumConsecutiveGap().maximumGap(Arrays.asList(5, 5, 5, 344, 5)));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        int n = A.size();

        int maxI = Integer.MIN_VALUE, minI = Integer.MAX_VALUE;
        for (int value : A) {
            maxI = Math.max(maxI, value);
            minI = Math.min(minI, value);
        }
        int sizeOfBucket = (maxI - minI) / n + 1;

        int[][] buckets = new int[n][2];
        for (int[] bucket : buckets) {
            bucket[0] = Integer.MAX_VALUE;
            bucket[1] = Integer.MIN_VALUE;
        }

        for (int value : A) {
            int bucket = (value - minI) / sizeOfBucket;
            buckets[bucket][0] = Math.min(buckets[bucket][0], value - minI);
            buckets[bucket][1] = Math.max(buckets[bucket][1], value - minI);
        }

        int maxGap = 0, prevValue = buckets[0][1];

        for (int i = 1; i < n; i++) {
            if (buckets[i][0] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, buckets[i][0] - prevValue);
            prevValue = buckets[i][1];
        }

        return maxGap;
    }
}
