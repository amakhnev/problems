import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TripletsWithSum {


    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("0.6, 0.7, 0.8, 1.2, 0.4".split(", ")));

        System.out.println("Result = " + new TripletsWithSum().solve(input));

    }

    public int solve(ArrayList<String> A) {
        if (A.size()<3){
            return 0;
        }
        float minSum =1.0f,maxSum =2.0f;
        ArrayList<Float> fArray = new ArrayList<>();


        for (String sValue : A){
            float fValue = Float.parseFloat(sValue);
            if (fValue<maxSum){
                fArray.add(fValue);
            }
        }
        Collections.sort(fArray);



        while (fArray.size()>=3){
            //remove items from the right which would add too much for 2 smallest items.
            while (fArray.size()>=3 && fArray.get(0)+fArray.get(1)+fArray.get(fArray.size()-1) > maxSum){
                fArray.remove(fArray.size()-1);
            }
            if (fArray.size()<3) return 0;



            float tempSum = fArray.get(0)+fArray.get(fArray.size()-1);
            for (int i=1;i<fArray.size()-1;i++){
                if (tempSum+fArray.get(i)>=maxSum){
                    break; // no need to look further
                }else{
                    if (tempSum+fArray.get(i)>minSum ){
                        return 1;
                    }
                }
            }

            fArray.remove(0);
        }


        return 0;
    }
}
