import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        System.out.println("Result = "+ new NearestSmallerElement().prevSmaller(
                new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8, 10))
        ));

    }


    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int a:A){
            int res = -1;
            while (!stack.empty()){
                int prev = stack.peek();
                if (prev>=a){
                    stack.pop();
                }else{
                    res=prev;
                    break;
                }
            }
            stack.push(a);
            result.add(res);
        }

        return result;
    }

}
