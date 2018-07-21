import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        System.out.println("Result = " + new IntersectionOfSortedArrays().intersect(
                Arrays.asList(10000000),
                Arrays.asList(10000000)
        ));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();

        int i=0,j=0;
        while (i<A.size() && j<B.size()){
            if (A.get(i)<B.get(j)){
                i++;
            }else if (A.get(i)>B.get(j)){
                j++;
            }else{
                result.add(A.get(i));
                i++;j++;
            }
        }
        return result;
    }
}
