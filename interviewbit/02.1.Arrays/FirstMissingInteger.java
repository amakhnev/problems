import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingInteger {

    public static void main(String[] args) {

        System.out.println("result = " + new FirstMissingInteger().firstMissingPositive(
                new ArrayList<>(Arrays.asList(1,2,4,3,5))
        ));

    }


    public int firstMissingPositive(ArrayList<Integer> A) {


        for (int i=A.size()-1; i>=0;i--){
            if (A.get(i)<=0){
                A.remove(i);
            }
        }

        if (A.size()==0){
            return 1;
        }

        int n = A.size()+1;
        for (int i=0;i<A.size();i++){
            if (A.get(i)>n-1){
                A.set(i,n-1);
            }
        }

        for (int i=0; i< A.size();i++){
            int originalValue = A.get(i) % n;
            if (A.get(originalValue-1)<n) {
                A.set(originalValue-1, A.get(originalValue-1) + n);
            }
        }


        for (int i=0; i< A.size();i++){
            if (A.get(i)<n){
                return i+1;
            }
        }

        return n;
    }

}
