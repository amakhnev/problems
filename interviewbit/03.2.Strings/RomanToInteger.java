
public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println("result = " + new RomanToInteger().romanToInt("XLX"));
    }


    public int romanToInt(String A) {
        int result =0;
        for (int i=0;i<A.length();i++){
            int currentInt = romanCharToInt(A.charAt(i));
            if (i<A.length()-1 && currentInt < romanCharToInt(A.charAt(i+1))){ // subtractive notation
                currentInt = romanCharToInt(A.charAt(i+1))-currentInt;
                i++;
            }
            result+=currentInt;
        }
        return result;
    }

    public int romanCharToInt(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
}
