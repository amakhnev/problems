import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaxDistance {

    public static void main(String[] args) {
        System.out.println("Result = "+ new MaxDistance().maximumGap(Arrays.asList(6,2,1,5,4,2,1,1,1)));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {

        int maxDiff=-1;
        int i, j;

        int [] rMax = new int[A.size()];
        int [] lMin = new int[A.size()];


        lMin[0] = A.get(0);
        for (i = 1; i < A.size(); ++i)
            lMin[i] = Math.min(A.get(i), lMin[i - 1]);

        rMax[A.size() - 1] = A.get(A.size() - 1);
        for (j = A.size() - 2; j >= 0; --j)
            rMax[j] = Math.max(A.get(j), rMax[j + 1]);

        i = 0; j = 0; maxDiff = -1;
        while (j < A.size() && i < A.size())
        {
            if (lMin[i] <= rMax[j])
            {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;

    }
}
