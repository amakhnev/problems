import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrixI {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input =  new ArrayList<>();
//        input.add(new ArrayList<>(Arrays.asList(1,2,3)));
//        input.add(new ArrayList<>(Arrays.asList(4,5,6)));
//        input.add(new ArrayList<>(Arrays.asList(7,8,9)));

//        input.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
//        input.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
//        input.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
//        input.add(new ArrayList<>(Arrays.asList(13,14,15,16)));

//        input.add(new ArrayList<>(Arrays.asList(1,2,3)));
//        input.add(new ArrayList<>(Arrays.asList(4,5,6)));
//        input.add(new ArrayList<>(Arrays.asList(7,8,9)));
//        input.add(new ArrayList<>(Arrays.asList(10,11,12)));

        input.add(new ArrayList<>(Arrays.asList(1)));
        input.add(new ArrayList<>(Arrays.asList(4)));
        input.add(new ArrayList<>(Arrays.asList(7)));
        input.add(new ArrayList<>(Arrays.asList(10)));

        System.out.println("Result = " + new SpiralOrderMatrixI().spiralOrder(input));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

        List<ArrayList<Integer>> copy = new ArrayList<>(A);
        ArrayList<Integer> result = new ArrayList<>();
        while (copy.size()>0){
            // go left
            if (copy.get(0).size()>0){
                for (int i=0;i<copy.get(0).size();i++){
                    result.add(copy.get(0).get(i));
                }
            }
            copy.remove(0);
            //go down on right side
            for (int i=0;i<copy.size();i++){
                result.add(copy.get(i).get(copy.get(i).size()-1));
                copy.get(i).remove(copy.get(i).size()-1);
                if (copy.get(i).size()==0){
                    copy.remove(i);
                    i--;
                }
            }

            // go right
            if (copy.size()>0){
                if ( copy.get(copy.size()-1).size()>0){
                    for (int i=copy.get(copy.size()-1).size()-1;i>=0;i--){
                        result.add(copy.get(copy.size()-1).get(i));
                    }
                }
                copy.remove(copy.size()-1);
            }

            //go up on left side, remove empty arrays if any
            for (int i=copy.size()-1;i>=0;i--){
                result.add(copy.get(i).get(0));
                copy.get(i).remove(0);
                if (copy.get(i).size()==0){
                    copy.remove(i);
                }
            }
        }
        return result;
    }
}
