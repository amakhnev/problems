import java.util.ArrayList;

public class MaxNonNegativeSubArray {


    public static void main(String[] args) {
        int size = 10;
        int offset = size / 2;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            a.add((int) (Math.random() * size) - offset);
        }

        System.out.println("Array = " + a);
        ArrayList<Integer> result = new MaxNonNegativeSubArray().maxset(a);
        System.out.println("Result = " + result);
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.isEmpty()) {
            return result;
        }
        long sum = -1;


        int i = 0;
        while (i < A.size()) {
            long curSum = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            while (i < A.size() && A.get(i) >= 0) { // calculate all positive numbers from this point forward
                temp.add(A.get(i));
                curSum += (long) A.get(i);
                i++;
            }
            if (curSum > sum && temp.size() > 0) { // save if something was found and it's bigger than previous sum
                sum = curSum;
                result = temp;

            }
            while (i < A.size() && A.get(i) < 0) { // skip all next negative
                i++;
            }

        }

        return result;
    }
}
