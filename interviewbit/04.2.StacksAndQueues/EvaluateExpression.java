import java.util.ArrayList;
import java.util.Arrays;/**/
import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {

        System.out.println("Result = " + new EvaluateExpression().evalRPN(
                new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"))
        ));
    }

    public int evalRPN(ArrayList<String> A) {

        Stack<Integer> values = new Stack<>();

        for (String str : A) {
            if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
                if (values.size() < 2) {
                    return 0; // wrong notation, there should be two operands for each operation
                }
                int op2 = values.pop();
                int op1 = values.pop();
                switch (str) {
                    case "*":
                        values.push(op1 * op2);
                        break;
                    case "/":
                        values.push(op1 / op2);
                        break;
                    case "+":
                        values.push(op1 + op2);
                        break;
                    case "-":
                        values.push(op1 - op2);
                        break;
                }
            } else {
                if (str.matches("-?\\d+"))
                    values.add(Integer.parseInt(str));
                else // wrong notation, return 0 as per requirements
                    return 0;
            }
        }
        return values.pop();
    }

}
