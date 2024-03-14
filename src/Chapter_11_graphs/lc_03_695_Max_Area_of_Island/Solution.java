package Chapter_11_graphs.lc_03_695_Max_Area_of_Island;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int currentArea = getAreOfIsland(grid, i, j);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int getAreOfIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + getAreOfIsland(grid, i - 1, j)
                + getAreOfIsland(grid, i, j + 1)
                + getAreOfIsland(grid, i + 1, j)
                + getAreOfIsland(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(solution.maxAreaOfIsland(arr));
    }
}
