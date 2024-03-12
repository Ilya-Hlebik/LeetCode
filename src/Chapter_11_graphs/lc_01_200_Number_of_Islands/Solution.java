package Chapter_11_graphs.lc_01_200_Number_of_Islands;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    visitIslands(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void visitIslands(int i, int j, char[][] grid) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        visitIslands(i - 1, j, grid);
        visitIslands(i, j + 1, grid);
        visitIslands(i + 1, j, grid);
        visitIslands(i, j - 1, grid);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] input = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(input));
    }
}
