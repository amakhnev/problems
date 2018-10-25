import java.util.Arrays;

public class TestRunner {

    public static void main(final String[] args) {
        ChangeMachine changeMachine = new ChangeMachine();


        System.out.println(changeMachine.change(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1), 13));
        System.out.println(changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2), 574));
    }
}
