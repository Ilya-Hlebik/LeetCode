package LeetCode75.Chapter_18_DP_Multi.lc_02_1143_Longest_Common_Subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, 0, 0, new Integer[text1.length() + 1][text2.length() + 1]);
    }

    public int dfs(String text1, String text2, int i, int j, Integer[][] memo) {
        if (i > text1.length() - 1 || j > text2.length() - 1) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + dfs(text1, text2, i + 1, j + 1, memo);
        } else {
            int max = Math.max(dfs(text1, text2, i + 1, j, memo), dfs(text1, text2, i, j + 1, memo));
            return memo[i][j] = max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }
}
