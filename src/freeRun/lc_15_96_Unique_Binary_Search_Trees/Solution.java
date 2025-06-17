package freeRun.lc_15_96_Unique_Binary_Search_Trees;

public class Solution {
    public int numTrees(int n) {
        return dfs(n, new Integer[n+1]);
    }

    private int dfs(int n, Integer[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int res = 0;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            res += (dfs(i, memo) * dfs(j, memo));
        }
        return memo[n] = res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(19));
    }
}
