import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println("Result = " + new ContainerWithMostWater().maxArea(new ArrayList<>(Arrays.asList(1, 5, 4, 3))));
    }


    public int maxArea(ArrayList<Integer> A) {
        int maxArea = 0;
        int i = 0, j = A.size() - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(A.get(i), A.get(j)));
            if (A.get(i) < A.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
