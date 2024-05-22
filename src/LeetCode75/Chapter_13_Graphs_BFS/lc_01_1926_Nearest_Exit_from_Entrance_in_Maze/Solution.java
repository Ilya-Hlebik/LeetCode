package LeetCode75.Chapter_13_Graphs_BFS.lc_01_1926_Nearest_Exit_from_Entrance_in_Maze;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Count count = new Count();
        dfs(maze, entrance, entrance[0], entrance[1], 0, count);
        return count.max;
    }

    private void dfs(char[][] maze, int[] entrance, int i, int j, int current, Count count) {
        if (i < 0 || j < 0 || i > maze.length - 1 || j > maze[0].length - 1 || maze[i][j] != '.') {
            return;
        }
        if (!(i == entrance[0] && j == entrance[1]) && (i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1)) {
            if (count.max == -1) {
                count.max = current;
            } else {
                count.max = Math.min(current, count.max);
            }
            return;
        }
        maze[i][j] = '+';
        dfs(maze, entrance, i - 1, j, current + 1, count);
        dfs(maze, entrance, i, j + 1, current + 1, count);
        dfs(maze, entrance, i + 1, j, current + 1, count);
        dfs(maze, entrance, i, j - 1, current + 1, count);
        maze[i][j] = '.';
    }
}

class Count {
    int max = -1;
}
