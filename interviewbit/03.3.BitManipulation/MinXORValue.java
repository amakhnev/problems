import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXORValue {

    public static void main(String[] args) {

        System.out.println("Result = " + new MinXORValue().findMinXor(new ArrayList<>(Arrays.asList(0,2 ,5 ,7))));

    }


    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int minXor = Integer.MAX_VALUE;
        for (int i = 1; i < A.size(); i++) {
            minXor = Math.min(minXor, A.get(i - 1) ^ A.get(i));
        }
        return minXor;
    }
}
