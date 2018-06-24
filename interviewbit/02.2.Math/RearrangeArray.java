import java.util.ArrayList;

public class RearrangeArray {


    public void arrange(ArrayList<Integer> a) {

        int size = a.size();
        for (int i = 0; i < size; i++) {
            int product = (a.get(a.get(i)) % size) * size + a.get(i);
            a.set(i, product);
        }

        for (int i = 0; i < size; i++) {
            int temp = a.get(i);
            a.set(i, temp / size);
        }
    }
}
