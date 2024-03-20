package Chapter_11_graphs.lc_11_Number_of_Connected_Components_In_An_Undirected_Graphn;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countComponents(int n, int[][] edges) {
        if (n == 1 || edges == null || edges.length == 0) {
            return n;
        }
        int[] parents = new int[n];
        int[] priority = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            priority[i] = 1;
        }
        for (int[] edge : edges) {
            int n1 = getParent(parents, edge[0]);
            int n2 = getParent(parents, edge[1]);
            if (priority[n1] > priority[n2]) {
                priority[n1] += priority[n2];
                parents[n2] = n1;
            } else {
                priority[n2] += priority[n1];
                parents[n1] = n2;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            int parent = getParent(parents, i);
            set.add(parent);
        }
        return set.size();
    }

    private int getParent(int[] parents, int i) {
        int p = parents[i];
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
                {4, 5}
        };
        System.out.println(solution.countComponents(6, arr));
    }
}
