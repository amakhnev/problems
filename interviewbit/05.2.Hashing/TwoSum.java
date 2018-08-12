import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(new TwoSum().twoSum(Arrays.asList(6,3,5,6,4,2,23,4),9));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> values = new HashMap<>();


        for (int i = 0; i < A.size(); i++){
            int curr = A.get(i);
            if (values.containsKey(B-curr)){
                result.add(values.get(B-curr)+1); // add 1 as should return 1-based order
                result.add(i + 1);
                return result;
            }else if (!values.containsKey(curr)){
                values.put(curr, i);
            }
        }

        return result;
    }
}
