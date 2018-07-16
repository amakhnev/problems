public class ReverseTheString {


    public static void main(String[] args) {
        System.out.println("Result = " + new ReverseTheString().reverseWords("   the sky    is blue  "));
    }

    public String reverseWords(String a) {

        String [] words = a.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1;i>=0;i--){
            if (!words[i].equals("")) {
                sb.append(words[i]);sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
