import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DiffkII {

    public static void main(String[] args) {
        System.out.println(new DiffkII().diffPossible(
                Arrays.asList(1,1,1,1,1,1,1,2,3,3,3,3,3,3),2
        ));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {

        HashSet<Integer> values = new HashSet<>();
        for (int num:A){
            if (values.contains(num+B) || values.contains(num-B)){
                return 1;
            }
            values.add(num);
        }
        return 0;
    }

}
