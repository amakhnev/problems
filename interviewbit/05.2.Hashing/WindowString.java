import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WindowString {

    public static void main(String[] args) {

        System.out.println(new WindowString().minWindow("bcebabacb", "abc"));

    }


    public String minWindow(String A, String B) {
        String result = "";
        int minLength = A.length() + 1, i = 0, j = 0, allCharsCount = 0;

        HashMap<Character, Integer> current = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        for (char c : B.toCharArray()) {
            int count = 1;
            if (target.containsKey(c)) {
                count += target.get(c);
            }
            target.put(c, count);
            current.put(c, 0);
        }


        for (j = 0; j < A.length(); j++) {
            char right = A.charAt(j);
            if (target.containsKey(right)) {
                if (current.get(right) < target.get(right)) {
                    allCharsCount++;
                }
                current.put(right, current.get(right) + 1);
            }

            if (B.length() - allCharsCount == 0) {
                for (char left = A.charAt(i); !current.containsKey(left) || current.get(left) > target.get(left); left = A.charAt(++i)) {
                    if (current.containsKey(left) && current.get(left) > target.get(left)) {
                        current.put(left, current.get(left) - 1);
                    }

                }
                if (j - i + 1 < minLength) {// we have exact number of characters required between i and j
                    result = A.substring(i, j + 1);
                    minLength = j - i + 1;
                }
            }


        }


        return result;
    }
}
