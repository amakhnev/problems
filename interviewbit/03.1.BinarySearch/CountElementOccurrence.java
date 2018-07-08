import java.util.Arrays;
import java.util.List;

public class CountElementOccurrence {

    public static void main(String[] args) {
        System.out.println("Result = " + new CountElementOccurrence().findCount(
                Arrays.asList(1,1,1,2,2,2,2,2,2)
                ,1));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findCount(final List<Integer> A, int B) {
        int firstOccurrence = binarySearch(A, B,0, A.size(), true);
        int lastOccurrence = binarySearch(A, B,0, A.size(), false);

        if ((firstOccurrence == -1) && (lastOccurrence == -1))
        {
            return 0;
        }
        else if (firstOccurrence == lastOccurrence)
        {
            return 1;
        }
        else
        {
            return (lastOccurrence - firstOccurrence + 1);
        }
    }

    public int binarySearch(final List<Integer> A, int B,int left,int right,boolean searchFirst){
        int result = -1;
        while (left<right){
            int mid = (right + left) /2;
            if (A.get(mid)==B){
                result = mid;
                if (searchFirst){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            else if (A.get(mid)>B){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return result;
    }
}
