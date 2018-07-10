import java.util.Arrays;
import java.util.List;

public class RotatedArray {

    public static void main(String[] args) {
        System.out.println("Result = " + new RotatedArray().findMin(Arrays.asList(1)));
    }

    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
        if (a.size()==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int value:a){
            min = Math.min(min,value);
        }
        return min;
    }
}
