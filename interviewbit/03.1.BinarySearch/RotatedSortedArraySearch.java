import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        System.out.println("result = " + new RotatedSortedArraySearch().search(
                Arrays.asList(4),4)
        );
    }


    public int search(final List<Integer> a, int b) {
        if (a.size()==0){
            return -1;
        }

        int left = 0, right = a.size()-1;

        while (left<=right){
            int mid = (right + left)/2;
            if (a.get(mid)==b){
                return mid;
            }


            if (a.get(left)<=a.get(mid)){ // sorted part of array
                if (a.get(left)<=b && b<a.get(mid)){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            } else if (a.get(mid+1)<=a.get(right)){
                if (a.get(mid)<b && b<=a.get(right)){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }else{
                right = mid-1;
            }
        }

        return -1;
    }
}
