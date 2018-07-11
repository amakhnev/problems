import java.util.Arrays;
import java.util.List;

public class MedianOfArray {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(-50, -42, -38, 1, 4, 9, 16, 33, 47);
        List<Integer> b = Arrays.asList(-44);

        System.out.println("result = " + new MedianOfArray().findMedianSortedArrays(a, b));
    }



    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
       if (a.size() == 0) {
            if (b.size() == 0) {
                return 0.0;
            } else {
                return getMedian(b);
            }
        }
        if (b.size() == 0) {
            return getMedian(a);
        }

        if (a.size()>b.size()){ // make first argument smaller in length
           return findMedianSortedArrays(b,a);
        }

        int x = a.size();
        int y = b.size();

        int low = 0;
        int high = x;
        while (low <= high) {
            int idxA = (low + high)/2;
            int idxB = (x + y + 1)/2 - idxA;

            // idxA is 0 => nothing is there on left side. Use Integer.MIN_VALUE
            // idxA is a.size() =>  there is nothing on right side. Use Integer.MAX_VALUE
            int maxLeftA = (idxA == 0) ? Integer.MIN_VALUE : a.get(idxA - 1);
            int minRightA = (idxA == x) ? Integer.MAX_VALUE : a.get(idxA);

            int maxLeftB = (idxB == 0) ? Integer.MIN_VALUE : b.get(idxB - 1);
            int minRightB = (idxB == y) ? Integer.MAX_VALUE : b.get(idxB);

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Bingo! we are in right place!
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2.0;
                } else {
                    return (double)Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) { //we are too far on right side for idxA. Go on left side.
                high = idxA - 1;
            } else { //we are too far on left side for idxA. Go on right side.
                low = idxA + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted.
        throw new IllegalArgumentException();

    }

    private double getMedian(List<Integer> a) {
        if (a.size() % 2 == 1) {
            return a.get(a.size() / 2);
        } else {
            return (a.get(a.size() / 2 - 1) + a.get(a.size() / 2)) / 2.0;
        }
    }


}
