public class DivideIntegers {

    public static void main(String[] args) {
        System.out.println("Result = " + new DivideIntegers().divide(5, 2));
    }


    public int divide(int A, int B) {

        boolean isNegative = ((A < 0) ^ (B < 0));
        long lA = Math.abs((long) A), lB = Math.abs((long) B);

        long result = 0, temp = 0;
        for (int i = 31; i >= 0; i--) {
            if (temp + (lB << i) <= lA) {
                temp += lB << i;
                result |= 1l << i;
            }
        }
        if (isNegative) {
            result = -result;
        }

        return (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) result;
    }


}
