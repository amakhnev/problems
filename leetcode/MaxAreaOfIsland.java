public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(test));
    }


    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, islandId = 2;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {//start
                    int area = markIsland(grid, i, j, islandId);
                    maxArea = Math.max(maxArea, area);
                    islandId++;
                }
            }
        }

        return maxArea;
    }

    private int markIsland(int[][] grid, int i, int j, int islandId) {
        grid[i][j] = islandId;
        int result = 1;
        if (i > 0 && grid[i - 1][j] == 1) {
            result += markIsland(grid, i - 1, j, islandId);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            result += markIsland(grid, i, j - 1, islandId);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            result += markIsland(grid, i + 1, j, islandId);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
            result += markIsland(grid, i, j + 1, islandId);
        }
        return result;
    }
}
