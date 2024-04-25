package Interview_prepare.newrub;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {
    int memo[][];

    public int minScore(int n, int[][] roads) {
        List<int[]> allRoutes = new ArrayList<>();
        int currentMin = 0;
        int currentRoad = 0;
        for (int[] road : roads) {
            currentMin = Math.max(currentMin, road[2]);
            currentRoad = Math.max(Math.max(currentRoad, road[1]), road[0]);
            allRoutes.add(road);
            allRoutes.add(new int[]{road[1], road[0], road[2]});
        }
        memo = new int[currentRoad + 1][currentMin + 1];
        return dfs(n, allRoutes, 1, currentMin);
    }

    private int dfs(int n, List<int[]> allRoutes, int currentRoad, int currentMin) {
        if (currentRoad == n) {
            return memo[currentRoad][currentMin] = currentMin;
        }
        if (memo[currentRoad][currentMin] != 0) {
            return memo[currentRoad][currentMin];
        }
        int min = currentMin;
        for (int[] allRoute : allRoutes) {
            if (allRoute[0] == currentRoad) {
                int temp = allRoute[1];
                allRoute[1] = 0;
                min = Math.min(min, dfs(n, allRoutes, temp, Math.min(allRoute[2], currentMin)));
                allRoute[1] = temp;
            }
        }
        memo[currentRoad][currentMin] = min;
        return min;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        // System.out.println(solution9.minScore(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}));
        System.out.println(solution9.minScore(5, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
    }
}
