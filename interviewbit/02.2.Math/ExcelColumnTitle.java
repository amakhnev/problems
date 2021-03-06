public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        StringBuffer result = new StringBuffer();
        int temp = A;

        while (temp > 0) {
            int reminder = temp % 26;
            result.append((char) (reminder + 64));
            temp = temp / 26;
        }

        return result.reverse().toString();
    }
}
