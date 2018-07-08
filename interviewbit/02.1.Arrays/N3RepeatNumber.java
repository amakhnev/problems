import java.util.*;

public class N3RepeatNumber {

    public static void main(String[] args) {

        System.out.println("Result = " + new N3RepeatNumber().repeatedNumber(
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
        );

    }

    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {


        HashMap<Integer,Integer> numbers = new HashMap<>();
        for (int i=0;i<a.size();i++){
            if (numbers.containsKey(a.get(i))){
                numbers.replace(a.get(i), numbers.get(a.get(i))+1);
                continue;
            }
            if (numbers.size()<2){
                numbers.put(a.get(i),1);
                continue;
            }

            for (Iterator<Integer> iterator = numbers.keySet().iterator(); iterator.hasNext();) {
                int value = iterator.next();int count = numbers.get(value);
                if (count>1){
                    numbers.replace(value,count-1);
                }else{
                    iterator.remove();
                }
            }

        }

        if (numbers.size()>0){
            for (int num: numbers.keySet()){
                numbers.put(num,0);
            }
            for (int value:a){
                if (numbers.containsKey(value)){
                    numbers.replace(value,numbers.get(value)+1);
                }
            }
            for (int num: numbers.keySet()){
                if (numbers.get(num)>a.size()/3){
                    return num;
                }
            }
        }

        return -1;

    }
}
