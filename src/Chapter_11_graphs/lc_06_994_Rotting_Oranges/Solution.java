package Chapter_11_graphs.lc_06_994_Rotting_Oranges;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                if (grid[i][j] == 2) {
                    queue.add(Map.entry(i, j));
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty() && freshCount != 0) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Map.Entry<Integer, Integer> poll = queue.poll();
                freshCount -= dfs(grid, poll.getKey(), poll.getValue(), queue);
            }

        }
        return freshCount != 0 ? -1 : time;
    }

    private int dfs(int[][] grid, int i, int j, Queue<Map.Entry<Integer, Integer>> queue) {
        int rotted = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            rotted = getRotted(grid, i - 1, queue, rotted, j);
        }
        if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 1) {
            rotted = getRotted(grid, i, queue, rotted, j + 1);
        }
        if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 1) {
            rotted = getRotted(grid, i + 1, queue, rotted, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            rotted = getRotted(grid, i, queue, rotted, j - 1);
        }
        return rotted;
    }

    private int getRotted(int[][] grid, int i, Queue<Map.Entry<Integer, Integer>> queue, int rotted, int j) {
        grid[i][j] = 2;
        queue.add(Map.entry(i, j));
        rotted++;
        return rotted;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int[][] arr2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        int[][] arr3 = {
                {0, 2}
        };
        System.out.println(solution.orangesRotting(arr));
        System.out.println(solution.orangesRotting(arr2));
        System.out.println(solution.orangesRotting(arr3));
    }
}
