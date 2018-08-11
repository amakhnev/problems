import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(5, 2));
    }


    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        return combine(B, 1, A);
    }

    private ArrayList<ArrayList<Integer>> combine(int length, int minNum, int maxNum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (length == 1) {
            for (int i = minNum; i <= maxNum; i++) {
                result.add(new ArrayList<>(Arrays.asList(i)));
            }
        } else {
            for (int i = minNum; i <= maxNum - length + 1; i++) {
                ArrayList<ArrayList<Integer>> prevArrays = combine(length - 1, i + 1, maxNum);

                for (ArrayList<Integer> prevArr : prevArrays) {
                    prevArr.add(0, i);
                }
                result.addAll(prevArrays);
            }
        }

        return result;
    }

}
