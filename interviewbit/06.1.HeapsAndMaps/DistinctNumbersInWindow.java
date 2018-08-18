import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {

    public static void main(String[] args) {
        System.out.println(new DistinctNumbersInWindow().dNums(
                new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)), 5
        ));
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < B - 1; i++) {
            numbers.put(A.get(i), numbers.containsKey(A.get(i)) ? numbers.get(A.get(i)) + 1 : 1);
        }

        for (int i = B - 1; i < A.size(); i++) {
            numbers.put(A.get(i), numbers.containsKey(A.get(i)) ? numbers.get(A.get(i)) + 1 : 1);
            if (i >= B) {
                if (numbers.get(A.get(i - B)) > 1) {
                    numbers.put(A.get(i - B), numbers.get(A.get(i - B)) - 1);
                } else {
                    numbers.remove(A.get(i - B));
                }
            }
            result.add(numbers.size());
        }

        return result;
    }

}
