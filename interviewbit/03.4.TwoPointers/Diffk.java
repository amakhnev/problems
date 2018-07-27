import java.util.ArrayList;
import java.util.Arrays;

public class Diffk {

    public static void main(String[] args) {
        System.out.println("Result = " + new Diffk().diffPossible(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4)), 0));
    }


    public int diffPossible(ArrayList<Integer> A, int B) {
        if (B < 0)
            return diffPossible(A, -B);

        int i = 0, j = 1;
        while (i < j && j < A.size()) {
            if (A.get(j) - A.get(i) - B == 0) {
                return 1;
            }
            if (A.get(j) - A.get(i) > B && i < j - 1) {
                i++;
            } else {
                j++;
            }

        }
        return 0;
    }
}
