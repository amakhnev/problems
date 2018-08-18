import java.util.*;

public class NMaxPairCombinations {

    public static void main(String[] args) {
        System.out.println(new NMaxPairCombinations().solve(
                new ArrayList<>(Arrays.asList(4, 5, 6, 3, 2, 1, -2334)),
                new ArrayList<>(Arrays.asList(-1, -1, -1, 1, 1, 1))
        ));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int n = A.size();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            for (int j = B.size() - 1; j >= 0; j--) {
                if (queue.size() < n) {
                    queue.add(A.get(i) + B.get(j));
                } else {
                    if (A.get(i) + B.get(j) - queue.peek() > 0) {
                        queue.poll();
                        queue.add(A.get(i) + B.get(j));
                    } else {
                        break;
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>(queue);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

}
