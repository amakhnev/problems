import java.util.ArrayList;
import java.util.List;

public class HammingDistance {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(96);
        A.add(2);
        System.out.println("Result = " + new HammingDistance().hammingDistance(A));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> A) {
        int result = 0;
        int M = 1000000007;
        if (A.size() < 2) {
            return result;
        }

        List<Integer> array = new ArrayList<>(A);

        boolean isComplete = false;
        while (!isComplete) {
            List<Integer> arrayNew = new ArrayList<>();
            long numZeroes = 0;
            long numOnes = 0;
            isComplete = true;
            for (int value : array) {

                if (value % 2 == 0) {
                    numZeroes++;
                } else {
                    numOnes++;
                }
                isComplete = isComplete && value == 0;
                arrayNew.add(value >>> 1);
            }
            result = (result + (int) (2 * (numZeroes % M) * (numOnes % M) % M)) % M;
            array = arrayNew;
        }

        return result % M;
    }
}
