package LeetCode75.Chapter_13_Graphs_BFS.lc_01_1926_Nearest_Exit_from_Entrance_in_Maze;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int result = dfs(maze, entrance, entrance[0], entrance[1], 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(char[][] maze, int[] entrance, int i, int j, int current) {
        if (i < 0 || j < 0 || i > maze.length - 1 || j > maze[0].length - 1 || maze[i][j] != '.') {
            return Integer.MAX_VALUE;
        }
        if (!(i == entrance[0] && j == entrance[1]) && (i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1)) {
            return current;
        }

        maze[i][j] = '+';
        int up = dfs(maze, entrance, i - 1, j, current + 1);
        int right = dfs(maze, entrance, i, j + 1, current + 1);
        int down = dfs(maze, entrance, i + 1, j, current + 1);
        int left = dfs(maze, entrance, i, j - 1, current + 1);
        maze[i][j] = '.';

        return Math.min(Math.min(up, right), Math.min(down, left));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] array = {
                {'+', '.', '+', '+', '+', '+', '+'},
                {'+', '.', '+', '.', '.', '.', '+'},
                {'+', '.', '+', '.', '+', '.', '+'},
                {'+', '.', '.', '.', '.', '.', '+'},
                {'+', '+', '+', '+', '.', '+', '.'}
        };
        System.out.println(solution.nearestExit(array, new int[]{0, 1}));
    }
}
