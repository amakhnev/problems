import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {


    public static void main(String[] args) {
        System.out.println("Result = " + new RemoveDuplicatesFromSortedArrayII().removeDuplicates(
                new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 7, 7, 7, 7, 7, 7))
        ));
    }


    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() < 2) {
            return a.size();
        }

        int prev = a.get(0);
        int numOfDuplicates = 1, maxNumOfDuplicates = 2;


        int i = 1; // index for end of new array

        for (int j = 1; j < a.size(); j++) {
            int curr = a.get(j);

            if (curr == prev) {
                if (numOfDuplicates < maxNumOfDuplicates) {
                    numOfDuplicates++;
                    a.set(i++, curr);
                }
            } else {
                prev = curr;
                a.set(i++, curr);
                numOfDuplicates = 1;
            }
        }
        return i;
    }


}
