public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println("Result = " + new TrappingRainWater().trap(
                new int[]{4}
        ));
        System.out.println("Result = " + new TrappingRainWater().trap(
                new int[]{4, 2, 0, 3, 2, 5}
        ));
        System.out.println("Result = " + new TrappingRainWater().trap(
                new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
        ));
        System.out.println("Result = " + new TrappingRainWater().trap(
                new int[]{1,2,1}
        ));

    }

    public int trap(int[] height) {
        int result =0;
        int[] maximumsLeft = new int[height.length], maximumsRight =new int[height.length];
        for (int i =0; i< height.length; i++){
            maximumsLeft[i] = Math.max(i>0?maximumsLeft[i-1]:0, height[i]);
            maximumsRight[height.length-1-i] = Math.max(i>0?maximumsRight[height.length-i]:0,height[height.length-1-i]);
        }

        for (int i =0; i< height.length; i++){
            if (height[i] < Math.min(maximumsLeft[i],maximumsRight[i])){
                result += Math.min(maximumsLeft[i],maximumsRight[i]) - height[i];
            }
        }
        return result;
    }

    public int trapNaive(int[] height) {
        // for each element need to find maximum elemtn on the left and on the right.

        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int k = i + 1; k < height.length; k++) {
                maxRight = Math.max(maxRight, height[k]);
            }
            if (Math.min(maxLeft, maxRight) > height[i]) {
                result += Math.min(maxLeft, maxRight) - height[i];
            }

        }
        return result;
    }
}
