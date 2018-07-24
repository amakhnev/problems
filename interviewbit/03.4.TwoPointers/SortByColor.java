import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2));
        new SortByColor().sortColors(a);
        System.out.println("Result = " + a);
    }

    public void sortColors(ArrayList<Integer> a) {
        int[] buckets = new int[3];
        for (int num : a) {
            buckets[num]++;
        }
        int count = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                a.set(count++, i);
            }
        }
    }
}
