public class PowerOfTwoIntegers {

    public static void main(String[] args) {

        System.out.println("Result = " + new PowerOfTwoIntegers().isPower(1024000000));
    }

    public int isPower(int A) {

        if (A == 1)
            return 1;

        for (int i = 2; i * i <= A; i++) {
            int x = A;

            while (x % i == 0) {
                x /= i;
            }

            if (x == 1) {
                return 1;
            }
        }

        return 0;

    }
}
