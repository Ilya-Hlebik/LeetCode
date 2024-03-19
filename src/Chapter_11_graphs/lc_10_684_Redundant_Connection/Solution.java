package Chapter_11_graphs.lc_10_684_Redundant_Connection;

import java.util.Arrays;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            if (!union(parents, rank, edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    public int findParent(int[] parents, int n) {
        int p = parents[n];
        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }

    public boolean union(int[] parents, int[] rank, int n1, int n2) {
        int p1 = findParent(parents, n1);
        int p2 = findParent(parents, n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parents[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parents[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {9, 10},
                {5, 8},
                {2, 6},
                {1, 5},
                {3, 8},
                {4, 9},
                {8, 10},
                {4, 10},
                {6, 8},
                {7, 9}
        };
        System.out.println(Arrays.toString(solution.findRedundantConnection(arr)));
    }
}
