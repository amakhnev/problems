import java.util.ArrayList;

public class MaximumAbsoluteDifference {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

//        a.add(0);
//        a.add(1); a.add(-3);a.add(4); a.add(-1);
        a.add(2); a.add(1);a.add(-5); a.add(4);

        System.out.println("Result = " + new MaximumAbsoluteDifference().maxArr(a));
    }


    public int maxArr(ArrayList<Integer> A) {
        if (A.size()==0){
            return 0;
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i=0;i<A.size();i++){
            max1 = Math.max(max1,A.get(i)+i);
            min1 = Math.min(min1,A.get(i)+i);
            max2 = Math.max(max2,A.get(i)-i);
            min2 = Math.min(min2,A.get(i)-i);
        }
        return Math.max(max1-min1,max2-min2);
    }


}
