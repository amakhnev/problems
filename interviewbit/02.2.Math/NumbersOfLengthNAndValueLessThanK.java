import java.util.ArrayList;

public class NumbersOfLengthNAndValueLessThanK {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(0);
        A.add(1);
        A.add(5);
        System.out.println("Result = " + new NumbersOfLengthNAndValueLessThanK().solve(A, 1, 2)); // expected 2


 /*       ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(0);A.add(1);A.add(2);A.add(5);
        System.out.println("Result = " + new NumbersOfLengthNAndValueLessThanK().solve(A,3,210)); // expected 20
*/

    }

    public int solve(ArrayList<Integer> A, int B, int C) {
        String cStr = "" + C;
        if (cStr.length() < B) {
            return 0;
        }
        if (cStr.length() > B) { // return total number of permutations
            int result = (int) Math.pow(A.size(), B);
            if (A.contains(0) && B > 1) {
                result = result - (int) Math.pow(A.size(), B - 1);
            }
            return result;
        }

        return solve(A, B, cStr, B > 1);
    }

    public int solve(ArrayList<Integer> A, int B, String C, boolean isfirstIteration) {
        int result = 0;
        // find number of number less than first
        int firstDigitC = Integer.parseInt("" + C.charAt(0));
        int lessNums = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < firstDigitC) {
                lessNums++;
            }
        }
        if (isfirstIteration && A.contains(0)) {
            lessNums--;
        }

        if (C.length() == 1) {
            return lessNums;
        }


        result = (int) (lessNums * Math.pow(A.size(), C.length() - 1));
        if (A.contains(firstDigitC)) {
            result = result + solve(A, B - 1, C.substring(1), false);
        }
        return result;
    }
}
