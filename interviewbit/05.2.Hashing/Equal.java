import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Equal {

    public static void main(String[] args) {
        System.out.println(new Equal().equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8))));
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<Integer>> values = new HashMap<>();
        ArrayList<Integer> smallest = new ArrayList<>();

        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if (values.containsKey(sum)) {
                    if (values.get(sum).size() == 2 && !values.get(sum).contains(i) && !values.get(sum).contains(j)) {
                        values.get(sum).add(i);
                        values.get(sum).add(j);
                        if (smallest.size() == 0 || compare(values.get(sum), smallest) < 0) {
                            smallest = values.get(sum);
                        }
                    }

                } else {
                    values.put(A.get(i) + A.get(j), new ArrayList<>(Arrays.asList(i, j)));
                }
            }

        }


        return smallest;
    }

    public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        int i = 0;
        while (i < Math.max(a1.size(), a2.size())) {
            if (i >= a1.size()) {
                return -1;
            }
            if (i >= a2.size()) {
                return 1;
            }
            if (a1.get(i) != a2.get(i)) {
                return a1.get(i) < a2.get(i) ? -1 : 1;
            }
            i++;
        }
        return 0;
    }
}
