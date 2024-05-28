package LeetCode75.Chapter_13_Graphs_BFS.lc_02_994_Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int countOfFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    countOfFresh++;
                }
            }
        }
        int[][] diff = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty() && countOfFresh>0) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                visited[x][y] = true;

                for (int[] ints : diff) {
                    if ((x + ints[0]) >= 0 && (x + ints[0]) < grid.length && (y + ints[1]) >= 0 && (y + ints[1]) < grid[0].length && grid[x + ints[0]][y + ints[1]] == 1 && !visited[x + ints[0]][y + ints[1]]) {
                        countOfFresh--;
                        grid[x + ints[0]][y + ints[1]] = 2;
                        queue.add(new int[]{x + ints[0], y + ints[1]});
                    }
                }
            }
        }
        return countOfFresh == 0 ? count : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(solution.orangesRotting(array));
    }
}
