package Top100Liked.Chapter_5_Graph.lc_03_994_Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty() && freshCount != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                freshCount -= visitCel(poll[0] - 1, poll[1], queue, grid);
                freshCount -= visitCel(poll[0], poll[1] + 1, queue, grid);
                freshCount -= visitCel(poll[0] + 1, poll[1], queue, grid);
                freshCount -= visitCel(poll[0], poll[1] - 1, queue, grid);
            }
            count++;
        }
        return freshCount == 0 ? count : -1;
    }

    private int visitCel(int i, int j, Queue<int[]> queue, int[][] grid) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        queue.add(new int[]{i, j});
        return 1;
    }
}
