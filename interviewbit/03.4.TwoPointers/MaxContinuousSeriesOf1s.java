import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOf1s {

    public static void main(String[] args) {
        System.out.println("Result = " + new MaxContinuousSeriesOf1s().maxone(
                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), 5
        ));
    }


    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, maxValue = 0, maxStartIdx = 0, currentZeros = 0, currentValue = 0;

        for (int j = 0; j < A.size(); j++) {
            currentValue++;
            if (A.get(j) == 0) {
                if (currentZeros == B) {
                    for (; i <= j; i++) {
                        currentValue--;
                        if (A.get(i) == 0) {
                            i++;
                            break;
                        }
                    }
                } else {
                    currentZeros++;
                }
            }
            if (currentValue > maxValue) {
                maxValue = currentValue;
                maxStartIdx = i;
            }
        }

        for (int k = maxStartIdx; k < maxStartIdx + maxValue; k++) {
            result.add(k);
        }
        return result;
    }
}
