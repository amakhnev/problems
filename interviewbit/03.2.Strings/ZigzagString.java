public class ZigzagString {

    public static void main(String[] args) {
        System.out.println("result = " + new ZigzagString().convert("PAYPALISHIRING", 1));
    }


    public String convert(String A, int B) {
        if (B == 1) {
            return A;
        }
        StringBuilder[] sbs = new StringBuilder[B];
        for (int i = 0; i < B; i++) {
            sbs[i] = new StringBuilder();
        }
        int num = 0;
        boolean descending = false;
        for (char c : A.toCharArray()) {
            sbs[num].append(c);
            if (descending) {
                num--;
                if (num == 0) {
                    descending = false;
                }
            } else {
                num++;
                if (B - num == 1) {
                    descending = true;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) {
            result.append(sb);
        }
        return result.toString();
    }

}
