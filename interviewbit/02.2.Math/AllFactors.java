import java.util.ArrayList;


public class AllFactors {

    public static void main(String[]args){
        System.out.println("Result = "+ new AllFactors().allFactors(64456));
    }

    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                result.add(i);
            }
        }
        int size = result.size();
        for (int i = 0; i < size; i++) {
            if (A / result.get(size - i - 1) != result.get(size - i - 1)) {
                result.add(A / result.get(size - i - 1));
            }
        }
        return result;
    }

}




