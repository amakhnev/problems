import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
//        a.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
//        a.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
//        a.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
//        a.add(new ArrayList<>(Arrays.asList(13,14,15,16)));

        a.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        a.add(new ArrayList<>(Arrays.asList(6,7,8,9,10)));
        a.add(new ArrayList<>(Arrays.asList(11,12,13,14,15)));
        a.add(new ArrayList<>(Arrays.asList(16,17,18,19,20)));
        a.add(new ArrayList<>(Arrays.asList(21,22,23,24,25)));

        new RotateMatrix().rotate(a);
        System.out.println("a = " + a);
    }


    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a.size()<=1){
            return;
        }
        int n = a.size();

        for (int offset =0;offset<n/2;offset++){
            for (int i = 0; i<n-2*offset-1;i++){


                int rowTopRowPoint = offset ,colTopRowPoint = offset+i;
                int rowLeftColPoint = n-offset-1-i ,colLeftColPoint = offset;
                int rowBotRowPoint = n-offset-1,colBotRowPoint = n-offset-1-i;
                int rowRightColPoint = offset+i, colRightColPoint = n-offset-1;

                int temp = a.get(rowTopRowPoint).get(colTopRowPoint); // top row value

                a.get(rowTopRowPoint).set(colTopRowPoint,a.get(rowLeftColPoint).get(colLeftColPoint)); //left column to top row
                a.get(rowLeftColPoint).set(colLeftColPoint,a.get(rowBotRowPoint).get(colBotRowPoint));//bottom row to left column
                a.get(rowBotRowPoint).set(colBotRowPoint,a.get(rowRightColPoint).get(colRightColPoint)); //right column to bottom row
                a.get(rowRightColPoint).set(colRightColPoint,temp); // top row(saved) to right column

            }
        }

    }
}
