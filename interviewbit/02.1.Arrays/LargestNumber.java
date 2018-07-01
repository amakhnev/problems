import jdk.nashorn.internal.ir.LiteralNode;

import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(Arrays.asList(0, 0, 0, 0, 0)));
    }

    public String largestNumber(final List<Integer> A) {

        ArrayList<String> copy = new ArrayList<>();
        boolean allZeroes = true;
        for (int value:A){
            copy.add(""+value);
            allZeroes = allZeroes && (value==0);
        }

        if (allZeroes){
            return "0";
        }


        copy.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);}
        });

        StringBuilder result = new StringBuilder();
        for (String value : copy) {
            result.append(value);
        }
        return result.toString();
    }


}
