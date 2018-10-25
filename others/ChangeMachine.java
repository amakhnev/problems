import java.util.*;

public class ChangeMachine {

    public enum UKCoin {
        TWO_POUNDS(200),
        ONE_POUND(100),
        FIFTY_PENCE(50),
        TWENTY_PENCE(20),
        TEN_PENCE(10),
        FIVE_PENCE(5),
        TWO_PENCE(2),
        ONE_PENNY(1);

        private final int value;

        UKCoin(Integer value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static UKCoin getByValue(int value) {
            for (UKCoin coin : values()) {
                if (coin.getValue() - value == 0) {
                    return coin;
                }
            }
            throw new IllegalArgumentException("No coin of denomination " + value + " exists in the UK.");
        }
    }

    public static void main(final String[] args) {
        ChangeMachine changeMachine = new ChangeMachine();

        System.out.println(changeMachine.change(13));
        System.out.println(changeMachine.change(574));
//        System.out.println(changeMachine.change(0));
//        System.out.println(changeMachine.change(-23));

        System.out.println(changeMachine.change(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1), 13));
        System.out.println(changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2), 574));

//        System.out.println(changeMachine.change(Arrays.asList(5, 2, 2, 2), 6));
//        System.out.println(changeMachine.change(Arrays.asList(5, 2, 2, 2, 1), 6));
//        System.out.println(changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2), 574));

//        System.out.println(changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2), 0));
//        System.out.println(changeMachine.change(Arrays.asList(200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2), -10));
//        System.out.println(changeMachine.change(Arrays.asList(), 574));
    }

    /**
     * This function return the minimum number of UK coins which adds to target value.
     *
     * @param value - target value to achieve in pence.
     * @return combination of UK coins which would add to target value.
     * @throws IllegalArgumentException if target is not positive.
     */
    public List<Integer> change(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value (" + value + ") should be positive. ");
        }

        List<Integer> result = new ArrayList<>();
        int change = value;
        for (UKCoin coin : UKCoin.values()) {
            while (change >= coin.getValue()) {
                result.add(coin.getValue());
                change -= coin.getValue();
            }
        }

        return result;
    }

    /**
     * This function takes a list of coins in the till and return the correct coins which adds to target value.
     *
     * @param till  list of coins in UK denomination.
     * @param value - target value to achieve in pence.
     * @return combination of coins which would add to target value. If several combinations found -
     * combination with minimum number of coins is returned.
     * @throws IllegalArgumentException if target is not positive.
     * @throws IllegalArgumentException if list of coins is null or empty.
     */
    public List<Integer> change(List<Integer> till, int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value (" + value + ") should be positive.");
        }
        if (till == null || till.size() == 0) {
            throw new IllegalArgumentException("Till can't be empty.");
        }
        for (int num : till) { // check if all coins are coins indeed. Can delete from till, but follow Fail-Fast approach.
            UKCoin.getByValue(num);
        }

        Collections.sort(till);

        // use dynamic programming approach, much faster than naive
        boolean[][] solvable = new boolean[till.size()][value + 1];
        // first column
        for (int i = 0; i < till.size(); i++) {
            solvable[i][0] = true;
        }
        // first row
        for (int num : till) {
            if (num <= value) {
                solvable[0][num] = true;
            }
        }

        // rest of the matrix
        for (int i = 1; i < till.size(); i++) {
            for (int j = 1; j < value + 1; j++) {
                solvable[i][j] = solvable[i - 1][j] || ((till.get(i) <= j) && solvable[i - 1][j - till.get(i)]);
            }
        }

        if (!solvable[till.size() - 1][value]) { // not possible to find solution
            return null;
        }

        // try to backtrack and find all possible solutions in order to select minimum
        Set<List<Integer>> results = new HashSet<>();
        backtrack(till, till.size() - 1, solvable, value, results, new ArrayList<>());

        int minSize = Integer.MAX_VALUE;
        List<Integer> result = null;
        for (List<Integer> list : results) {
            if (list.size() < minSize) {
                minSize = list.size();
                result = list;
            }
        }
        return result;
    }

    private void backtrack(List<Integer> till, int numIdx, boolean[][] solvable, int target, Set<List<Integer>> results, List<Integer> path) {
        if (numIdx == 0) { // reached first entry - last in the list
            if (target == 0) { // can ignore the item as found the correct path already
                results.add(path);
            } else if (target > 0 && till.get(numIdx) == target) { // adding to the path
                path.add(till.get(numIdx));
                results.add(path);
            }// else not a solution
            return;
        }
        if (solvable[numIdx - 1][target]) { // there is a possible path which would ignore current item
            backtrack(till, numIdx - 1, solvable, target, results, new ArrayList<>(path));
        }
        if (target >= till.get(numIdx) && solvable[numIdx - 1][target - till.get(numIdx)]) { // there is a possible path which includes current item
            path.add(till.get(numIdx));
            backtrack(till, numIdx - 1, solvable, target - till.get(numIdx), results, path);
        }

    }

    // bruteforce approach, too slow
    public List<Integer> changeNaive(List<Integer> tillList, int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value (" + value + ") should be positive.");
        }
        if (tillList.size() == 0) {
            throw new IllegalArgumentException("Till can't be empty.");
        }

        HashMap<UKCoin, Integer> till = new HashMap<>();
        for (int num : tillList) {
            UKCoin coin = UKCoin.getByValue(num);
            till.put(coin, till.containsKey(coin) ? till.get(coin) + 1 : 1);
        }

        List<Integer> result = getCoinsFor(till, value, new ArrayList<>());
        if (result != null) {
            result.sort(Comparator.reverseOrder());
        }

        return result;
    }

    private List<Integer> getCoinsFor(HashMap<UKCoin, Integer> till, int value, List<Integer> coinsUsed) {
        HashSet<List<Integer>> options = new HashSet<>();
        for (UKCoin coin : UKCoin.values()) { //we choose what coin to use
            if (till.containsKey(coin)) {
                if (coin.getValue() > value) {
                    continue;
                }
                if (coin.getValue() - value == 0) {
                    List<Integer> coinsUsedNew = new ArrayList<>(coinsUsed);
                    coinsUsedNew.add(coin.getValue());
                    return coinsUsedNew;
                }
                coinsUsed.add(coin.getValue());
                if (till.get(coin) == 1) {
                    till.remove(coin);
                } else {
                    till.put(coin, till.get(coin) - 1);
                }
                List<Integer> resultforCoin = getCoinsFor(till, value - coin.getValue(), coinsUsed);
                coinsUsed.remove(coinsUsed.size() - 1);
                till.put(coin, till.containsKey(coin) ? till.get(coin) + 1 : 1);
                if (resultforCoin != null) {
                    options.add(resultforCoin);
                }
            }
        }
        List<Integer> result = null;
        int minSize = Integer.MAX_VALUE;
        for (List<Integer> option : options) {
            if (option.size() < minSize) {
                result = option;
                minSize = option.size();
            }
        }

        return result;
    }


}
