package Chapter_14_2_D_Dynamic_Programming.lc_02_1143_Longest_Common_Subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, 0, 0, new int[text1.length()][text2.length()]);
    }

    public int dfs(String text1, String text2, int x, int y, int[][] memo) {
        if (x > text1.length() - 1 || y > text2.length() - 1) {
            return 0;
        } else if (memo[x][y] != 0) {
            return memo[x][y];
        } else if (text1.charAt(x) == text2.charAt(y)) {
            memo[x][y] = 1 + dfs(text1, text2, x + 1, y + 1, memo);
        } else {
            memo[x][y] = Math.max(dfs(text1, text2, x + 1, y, memo), dfs(text1, text2, x, y + 1, memo));
        }
        return memo[x][y];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("ezupkr", "ubmrapg"));
    }
}
