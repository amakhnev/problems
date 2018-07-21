import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedListsII {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(11,22,33,44,52));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(11,22,33,44,52));
        new MergeTwoSortedListsII().merge(a,b);

        System.out.println("A = " + a);
    }


    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int i=0,j=0;
        while (j<b.size()){
            if (i>=a.size() || a.get(i)>=b.get(j)){
                a.add(i,b.get(j));
                j++;
            }
            i++;
        }

    }
}
