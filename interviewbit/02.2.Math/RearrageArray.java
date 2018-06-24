import java.util.ArrayList;

public class RearrageArray {

    public static void main(String[] args) {
        ArrayList<Integer> a=  new ArrayList<Integer>();
        a.add(3);
        a.add(0);
        a.add(1);
        a.add(2);
        new RearrageArray().arrange(a);
        System.out.println(a);
    }

    public void arrange(ArrayList<Integer> a) {

        int l = a.size();

        for(int i = 0; i < l; i ++) {
            a.set(i, a.get(i) + (a.get(a.get(i)) % l) * l);
        }

        for(int i = 0; i < l; i ++) {
            a.set(i, (a.get(i) / l));
        }

    }

}
