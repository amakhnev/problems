public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {

        System.out.println("Result = "+new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1,2,3,4,5,6,7,8},
                new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13}
        ));
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int left =0,right = nums1.length;

        while (left<=right){
            int idx1 = (right + left )/2;
            int idx2 = (nums1.length + nums2.length + 1)/2 - idx1;

            int maxLeft1 = idx1==0?Integer.MIN_VALUE:nums1[idx1-1];
            int minRight1 = idx1==nums1.length?Integer.MAX_VALUE:nums1[idx1];

            int maxLeft2 = idx2==0?Integer.MIN_VALUE:nums2[idx2-1];
            int minRight2 = idx2==nums2.length?Integer.MAX_VALUE:nums2[idx2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Bingo! we are in right place!
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return ((double)Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2.0;
                } else {
                    return (double)Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) { //we are too far on right side for idx1. Go on left side.
                right = idx1 - 1;
            } else { //we are too far on left side for idx1. Go on right side.
                left = idx1 + 1;
            }

        }

        //should not be here at all as per math, would return exception
        return 0;
    }

}
