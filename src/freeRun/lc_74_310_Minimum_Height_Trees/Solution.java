package freeRun.lc_74_310_Minimum_Height_Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        int[]degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < adj.size(); i++) {
            degree[i] = adj.get(i).size();
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1){
                queue.add(i);
            }
        }
        int remaining = n;
        while (!queue.isEmpty() && remaining > 2){
            Integer u = queue.poll();
            remaining--;
            for (Integer v : adj.get(u)) {
                degree[v]--;
                if (degree[v] == 1){
                    queue.add(v);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
    }
}
