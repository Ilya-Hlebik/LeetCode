package Chapter_12_advanced_graphs.lc_04_778_Swim_in_Rising_Water;

import java.util.PriorityQueue;

public class Solution {

    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        priorityQueue.add(new int[]{grid[0][0], 0, 0});
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int maxWeight = grid[0][0];
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int weight = poll[0];
            int x = poll[1];
            int y = poll[2];
            seen[x][y] = true;
            maxWeight = Math.max(maxWeight, weight);
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                break;
            }
            if (x - 1 >= 0 && !seen[x - 1][y]) {
                priorityQueue.add(new int[]{grid[x - 1][y], x - 1, y});
            }
            if (y + 1 < grid[0].length && !seen[x][y + 1]) {
                priorityQueue.add(new int[]{grid[x][y + 1], x, y + 1});
            }
            if (x + 1 < grid.length && !seen[x + 1][y]) {
                priorityQueue.add(new int[]{grid[x + 1][y], x + 1, y});
            }
            if (y - 1 >= 0 && !seen[x][y - 1]) {
                priorityQueue.add(new int[]{grid[x][y - 1], x, y - 1});
            }
        }
        return maxWeight;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {0, 2},
                {1, 3}
        };
        System.out.println(solution.swimInWater(grid));
    }

}
