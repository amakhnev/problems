import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeTheAbsoluteDifference {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(6, 9, 10));
        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 10));

        System.out.println("Result = " + new MinimizeTheAbsoluteDifference().solve(a, b, c));

    }


    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i = 0, j = 0, k = 0, minDiff = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size() && k < C.size()) {
            minDiff = Math.min(minDiff, Math.max(Math.max(A.get(i), B.get(j)), C.get(k)) - Math.min(Math.min(A.get(i), B.get(j)), C.get(k)));

            int minA = (i < A.size()) ? A.get(i) : Integer.MAX_VALUE;
            int minB = (j < B.size()) ? B.get(j) : Integer.MAX_VALUE;
            int minC = (k < C.size()) ? C.get(k) : Integer.MAX_VALUE;
            if (minA <= Math.min(minB, minC)) {
                i++;
                continue;
            }
            if (minB <= Math.min(minA, minC)) {
                j++;
                continue;
            }
            if (minC <= Math.min(minA, minB)) {
                k++;
                continue;
            }
        }
        return minDiff;
    }
}
