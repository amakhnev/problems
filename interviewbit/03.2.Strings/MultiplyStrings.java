public class MultiplyStrings {

    public static void main(String[] args) {
        String s1 = "01000000";
        String s2 = "0000025";

        System.out.println("result = " + new MultiplyStrings().multiply(s1,s2));
    }


    public String multiply(String A, String B) {

        if (A.length()==0 || B.length()==0){
            return "";
        }

        if (A.length()<B.length()){ // B should be shorted
            return multiply(B,A);
        }

        String result = "0";

        for (int i=B.length()-1;i>=0;i--){
            int numB = B.charAt(i)-'0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j=A.length()-1;j>=0;j--){
                int numA = A.charAt(j)-'0';
                sb.append((numA*numB + carry)%10);
                carry = (numA*numB + carry) / 10;
            }
            if (carry>0){
                sb.append(carry);
            }
            sb.reverse();
            for (int k=0;k<B.length()-1-i;k++){
                sb.append("0");
            }

            result = plus(result,sb.toString());
        }

        return result;
    }

    public String plus(String s1, String s2){
        int carry =0;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<Math.max(s1.length(),s2.length());i++){
            int num1 = s1.length()-1-i>=0? s1.charAt(s1.length()-1-i)-'0':0;
            int num2 = s2.length()-1-i>=0? s2.charAt(s2.length()-1-i)-'0':0;

            sb.append((num1 + num2 + carry) % 10);
            carry = (num1 + num2 + carry) / 10;
        }
        if (carry>0){
            sb.append(carry);
        }
        sb.reverse();
        while (sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}
