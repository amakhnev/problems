public class PowerOfTwo {

    public static void main(String[] args) {
        int result = new PowerOfTwo().power("147573952589676412928");
        System.out.println("result = " + result);

    }


    public int power(String A) {
        String str = new String(A);
        if (str.equals("1")||str.equals("0")){
            return 0;
        }
        while (true){
            if (str.equals("1")){
                return 1;
            }
            String [] next = divideWithReminder(str,2);
            if (!next[1].equals("0")){
                return 0;
            }
            str = next[0];
        }
   }

    public String [] divideWithReminder(String string, int divisor){
        StringBuilder sb = new StringBuilder();
        int carry =0;
        for (int i=0;i<string.length();i++){
            int current = string.charAt(i)-'0';
            sb.append((current+carry)/divisor);
            carry = ((current+carry) % divisor)*10;
        }
        while(sb.charAt(0)=='0'){
            sb.delete(0,1);
        }
        return new String[]{sb.toString(),""+carry};
    }
}
