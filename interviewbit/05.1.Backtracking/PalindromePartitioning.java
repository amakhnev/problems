import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class PalindromePartitioning {

    public static void main(String[] args) {


        System.out.println(new PalindromePartitioning().partition("aabcbb"));

    }


    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            String left = a.substring(0, i + 1);
            if (isPalindrome(left)) {
                if (i < a.length() - 1) {
                    ArrayList<ArrayList<String>> right = partition(a.substring(i + 1));
                    for (ArrayList<String> partition : right) {
                        partition.add(0, left);
                        result.add(partition);
                    }
                } else {
                    result.add(new ArrayList<>(Arrays.asList(left)));
                }

            }
        }
        return result;
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
