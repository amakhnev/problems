import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-1, -2, 0, 0, 0, -3));
        System.out.println("Result = " + new NobleInteger().solve(a));

    }

    public int solve(ArrayList<Integer> A) {

        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            if (i != A.size() - 1 && A.get(i) == A.get(i + 1)) {
                continue;
            }
            if (A.get(i) == A.size() - i - 1) {
                return 1;
            }
        }
        return -1;
    }
}
