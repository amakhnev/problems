import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FourSum {

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(
                new ArrayList<>(Arrays.asList(1,0,-1,0,-2,2)),0
        ));
    }


    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);

        for (int i=0;i<A.size()-3;i++){
            for (int j=i+1;j<A.size()-2;j++){
                int target = B - A.get(i)-A.get(j);
                int k = j+1,l=A.size()-1;
                while (k<l){
                    if (A.get(k)+A.get(l)-target==0){
                        ArrayList seq = new ArrayList(Arrays.asList(A.get(i),A.get(j),A.get(k),A.get(l)));
                        if (!result.contains(seq)){
                            result.add(seq);
                        }
                    }
                    if (A.get(k)+A.get(l)-target<=0){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }

        return result;
    }

}
