package Chapter_14_2_D_Dynamic_Programming.lc_08_115_Distinct_Subsequences;

public class Solution {
    Integer memo[][];

    public int numDistinct(String s, String t) {
        memo = new Integer[s.length() + 1][t.length() + 1];
        return dfs(s, t, 0, 0);
    }

    public int dfs(String s, String t, int sIndex, int tIndex) {
        if (memo[sIndex][tIndex] != null) {
            return memo[sIndex][tIndex];
        }
        if (tIndex > t.length() - 1) {
            return 1;
        }
        if (sIndex > s.length() - 1) {
            return 0;
        }
        memo[sIndex][tIndex] = 0;
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            memo[sIndex][tIndex] += dfs(s, t, sIndex + 1, tIndex + 1) +
                    dfs(s, t, sIndex + 1, tIndex);
            return memo[sIndex][tIndex];
        }
        memo[sIndex][tIndex] = dfs(s, t, sIndex + 1, tIndex);
        return memo[sIndex][tIndex];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
    }
}
