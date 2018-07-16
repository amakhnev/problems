public class MinimumCharactersPalindromic {


    public static void main(String[] args) {
        System.out.println("result = " + new MinimumCharactersPalindromic().solve("AAAS"));
    }

    public int solve(String A) {

        for (int i = A.length(); i>0;i--){
            String a = A.substring(0,i);
            StringBuilder sb = new StringBuilder(a);
            if ( a.equals(sb.reverse().toString())){
                return A.length()-i;
            }
        }
        return A.length();
    }

}
