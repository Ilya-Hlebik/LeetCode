package TopInterview150.Chapter_12_Graph_General.lc_01_200_Number_of_Islands;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[x].length - 1 || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2';
        dfs(grid, x-1, y);
        dfs(grid, x, y+1);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
    }
}
