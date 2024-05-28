package LeetCode75.Chapter_12_Graphs_DFS.lc_03_1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i =0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(-connection[0]);
        }
        return dfs(adj, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> adj, boolean[] visited, int from) {
        int count = 0;
        visited[from] = true;
        for (Integer to : adj.get(from)) {
            if (!visited[Math.abs(to)]){
                count += dfs(adj, visited, Math.abs(to)) + (to >0 ? 1: 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };
        System.out.println(solution.minReorder(6, array));
    }
}
