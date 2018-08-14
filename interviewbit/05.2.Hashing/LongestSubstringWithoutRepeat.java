import java.util.HashSet;

public class LongestSubstringWithoutRepeat {


    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String A) {
        int maxLength = 0, i = 0, j = 0;
        HashSet<Character> chars = new HashSet<>();

        while (j < A.length()) {
            char c = A.charAt(j);
            if (chars.contains(c)) {
                while (chars.contains(c)) {
                    chars.remove(A.charAt(i++));
                }
            }
            chars.add(c);
            maxLength = Math.max(maxLength, chars.size());

            j++;
        }

        return maxLength;
    }

}
