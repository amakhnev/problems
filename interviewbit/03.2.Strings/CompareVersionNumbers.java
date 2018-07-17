import java.util.Arrays;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println("Result = " + new CompareVersionNumbers().compareVersion("1", "1.0.8"));
    }

    public int compareVersion(String A, String B) {

        if (A.length() == 0 || B.length() == 0) {
            if (A.length() == B.length()) {
                return 0;
            }
            if (A.length() == 0) {
                return -1;
            }
            if (B.length() == 0) {
                return 1;
            }
        }

        String[] versionsA = A.split("\\.");
        String[] versionsB = B.split("\\.");

        for (int i = 0; i < Math.max(versionsA.length, versionsB.length); i++) {
            String vA = i < versionsA.length ? versionsA[i] : "0";
            String vB = i < versionsB.length ? versionsB[i] : "0";
            if (vA.length() != vB.length()) {
                char[] array = new char[Math.abs(vA.length() - vB.length())];
                Arrays.fill(array, '0');
                if (vA.length() > vB.length()) {
                    vB = new String(array) + vB;
                } else {
                    vA = new String(array) + vA;
                }
            }
            if (!vA.equals(vB)) {
                return Integer.signum(vA.compareTo(vB));
            }

        }

        return 0;
    }

}
