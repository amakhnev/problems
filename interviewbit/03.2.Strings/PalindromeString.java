public class PalindromeString {

    public static void main(String[] args) {
        System.out.println("Result = " + new PalindromeString().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public int isPalindrome(String A) {
        String result = A.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        for (int i=0;i<result.length()/2;i++){
            if (result.charAt(i)!=result.charAt(result.length()-1-i)){
                return 0;
            }
        }
        return 1;

    }
}
