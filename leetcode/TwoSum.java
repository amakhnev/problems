public class TwoSum {

    // https://leetcode.com/problems/two-sum/description/

    public static void main(String[] args) {
        int[] result = new TwoSum().twoSum(new int[]{2,5,6,7},9);

        System.out.println("Result = ["+result[0]+","+result[1]+"]");
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i =0 ;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j] ==target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

}
