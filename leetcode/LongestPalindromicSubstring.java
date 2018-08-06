public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
    }


    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            // find palindrome with center in i position
            String res1 = getPalindrome(s, i, i);
            // find palindrome with center at i and i+1
            String res2 = getPalindrome(s, i, i + 1);
            if (res1.length() > result.length() || res2.length() > result.length()) {
                result = res1.length() > res2.length() ? res1 : res2;
            }
        }
        return result;
    }

    public String getPalindrome(String s, int leftCenter, int rightCenter) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        if (leftCenter == rightCenter) {
            sb.append(s.charAt(leftCenter));
            k++;
        }
        while (leftCenter - k >= 0 && rightCenter + k < s.length() && s.charAt(leftCenter - k) == s.charAt(rightCenter + k)) {
            sb.insert(0, s.charAt(leftCenter - k));
            sb.append(s.charAt(rightCenter + k));
            k++;
        }
        return sb.toString();
    }

}
