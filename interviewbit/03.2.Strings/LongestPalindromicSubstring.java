public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println("result = " + new LongestPalindromicSubstring().longestPalindrome(
                "aababasba"));
    }

    public String longestPalindrome(String A) {

        if (A.length()<2){
            return A;
        }
        String result ="";

        for (int i=0;i<A.length()-1;i++){
            String res1 = findPalindrome(A,i,i);
            String res2 = findPalindrome(A,i,i+1);
            if (res1.length()>result.length()){
                result=res1;
            }
            if (res2.length()>result.length()){
                result=res2;
            }
        }

        return result;
    }

    public String findPalindrome(String A,int i,int j){
        if (A.charAt(i)!=A.charAt(j)){
            return "";
        }
        int k=0;
        while (i-k>=0 && j+k<A.length() && A.charAt(i-k)==A.charAt(j+k)){
            k++;
        }

        return A.substring(i-k+1,j+k);
    }

}




