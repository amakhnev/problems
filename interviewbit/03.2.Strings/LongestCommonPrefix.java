
import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList(
                "abcdefgh",

                "abcefghijk",

                "abc"
        ));

        System.out.println("Result = " + new LongestCommonPrefix().longestCommonPrefix(input));
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        StringBuilder sb = new StringBuilder();
        if (A.size()==0){
            return null;
        }

        int minLength = Integer.MAX_VALUE;
        for (String string:A){
            minLength = Math.min(minLength,string.length());
        }

        for (int i=0;i<minLength;i++){
            char toCompare = A.get(0).charAt(i);
            for (String string: A){
                if (string.charAt(i)!=toCompare){
                    return sb.toString();
                }
            }
            sb.append(toCompare);
        }

        return sb.toString();
    }
}
