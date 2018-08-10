import java.util.HashSet;

public class ColorfulNumber {

    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(23));
    }


    public int colorful(int A) {
        HashSet<Integer> products = new HashSet<>();
        String s = "" + A;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int num = getProductFor(s.substring(i, j).toCharArray());
                if (products.contains(num)) {
                    return 0;
                }
                products.add(num);
            }
        }

        return 1;
    }

    public int getProductFor(char[] nums) {
        int result = 1;
        for (char c : nums) {
            result *= (c - '0');
        }
        return result;
    }
}
