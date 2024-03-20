package Chapter_11_graphs.lc_12_Graph_Valid_Tree;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return true;
        }
        if (n == 1) {
            return false;
        }
        int[] parents = new int[n];
        int[] priority = new int[n];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            priority[i] = 1;
        }

        for (int[] edge : edges) {
            int p1 = getParent(parents, edge[0]);
            int p2 = getParent(parents, edge[1]);
            if (p1 == p2) {
                return false;
            }
            if (priority[p1] > priority[p2]) {
                priority[p1] += priority[p2];
                parents[p2] = p1;
            } else {
                priority[p2] += priority[p1];
                parents[p1] = p2;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            int parent = getParent(parents, i);
            set.add(parent);
        }
        return set.size() == 1;
    }

    private int getParent(int[] parents, int n) {
        int p = parents[n];
        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        };
        System.out.println(solution.validTree(5, arr));
    }
}
