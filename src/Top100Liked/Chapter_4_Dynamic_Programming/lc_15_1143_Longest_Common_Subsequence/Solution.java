package Top100Liked.Chapter_4_Dynamic_Programming.lc_15_1143_Longest_Common_Subsequence;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, 0, 0, new Integer[text1.length() + 1][text2.length() + 1]);
    }

    private int dfs(String text1, String text2, int index1, int index2, Integer[][] memo) {
        if (index1 > text1.length() - 1 || index2 > text2.length() - 1) {
            return 0;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        boolean value = text1.charAt(index1) == text2.charAt(index2);
        if (value) {
            return memo[index1][index2] = 1 + dfs(text1, text2, index1 + 1, index2 + 1, memo);
        }
        return memo[index1][index2] = Math.max(dfs(text1, text2, index1, index2 + 1, memo), dfs(text1, text2, index1+1, index2, memo));
    }
}
