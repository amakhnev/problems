import java.util.ArrayList;

public class MinStepsInInfiniteGrid {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(-7);b.add(-13);
        a.add(1);b.add(-5);

        System.out.println("Result = " + new MinStepsInInfiniteGrid().coverPoints(a,b));
    }


    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size()<=1 || B.size()<=1 || A.size()!=B.size()){
            return 0;
        }
        int result =0;

        for (int i=0;i<A.size()-1;i++){
            result += Math.max(Math.abs(A.get(i+1)-A.get(i)),Math.abs(B.get(i+1)-B.get(i)));
        }

        return result;
    }
}

