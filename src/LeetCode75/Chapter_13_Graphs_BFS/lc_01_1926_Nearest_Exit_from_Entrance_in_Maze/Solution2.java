package LeetCode75.Chapter_13_Graphs_BFS.lc_01_1926_Nearest_Exit_from_Entrance_in_Maze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int step = poll[2];

            for (int[] direction : directions) {
                int xn = x+ direction[0];
                int yn = y+ direction[1];
                if (xn < 0 || yn < 0 || xn > maze.length - 1 || yn > maze[0].length - 1 || maze[xn][yn] != '.') {
                    continue;
                }
                if (!(xn == entrance[0] && yn == entrance[1]) && (xn == 0 || yn == 0 || xn == maze.length - 1 || yn == maze[0].length - 1)) {
                    return step +1;
                }
                maze[xn][yn] = '+';
                queue.add(new int[]{xn, yn, step+1});
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
