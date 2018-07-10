import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

    public static void main(String[] args) {
        System.out.println("Result = " + new SortedInsertPosition().searchInsert(
                new ArrayList<>(Arrays.asList(1,3,5,6)),0
        ));
    }


    public int searchInsert(ArrayList<Integer> a, int b) {

        int left =0; int right = a.size();

        while (left < right){
            int mid = (right + left) / 2;
            if (a.get(mid)==b){
                return mid;
            }else if (a.get(mid)<b){
                left = mid+1;
            }else{
                right = mid;
            }

        }

        return left;
    }


}
