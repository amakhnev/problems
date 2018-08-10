import java.util.ArrayList;

public class NQueens {

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }


    public ArrayList<ArrayList<String>> solveNQueens(int a) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        loadSolution(result, a, 0, new ArrayList<>(), new boolean[a], new boolean[a * 2 - 1], new boolean[a * 2 - 1]);
        return result;
    }

    private void loadSolution(ArrayList<ArrayList<String>> result, int a, int row, ArrayList<String> pathSoFar, boolean[] columns, boolean[] leftDiagonals, boolean[] rightDiagonals) {
        // for each position in the row
        for (int i = 0; i < a; i++) {
            // continue if this position is conflicting with columns or left diagonals or right diagonals
            if (columns[i] || leftDiagonals[a - row + i - 1] || rightDiagonals[row + i]) {
                continue;
            }

            pathSoFar.add(getStringFor(i, a));
            if (a - row == 1) {// if row is a last row - we found a solution, add it into resulting array
                result.add(new ArrayList<>(pathSoFar));
            } else { // if row is not the last - mark column, left diagonal, right diagonal as busy
                columns[i] = true;
                leftDiagonals[a - row + i - 1] = true;
                rightDiagonals[row + i] = true;
                // call procedure for the next row
                loadSolution(result, a, row + 1, pathSoFar, columns, leftDiagonals, rightDiagonals);
                // release columns and diagonals
                columns[i] = false;
                leftDiagonals[a - row + i - 1] = false;
                rightDiagonals[row + i] = false;
            }
            // remove from the path
            pathSoFar.remove(pathSoFar.size() - 1);
        }

    }

    public String getStringFor(int column, int total) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            sb.append(i == column ? "Q" : ".");
        }
        return sb.toString();
    }
}
