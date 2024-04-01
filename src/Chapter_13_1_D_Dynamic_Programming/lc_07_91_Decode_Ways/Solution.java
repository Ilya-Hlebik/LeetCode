package Chapter_13_1_D_Dynamic_Programming.lc_07_91_Decode_Ways;

public class Solution {
    public int numDecodings(String s) {
        return dfs(s, 0, new Integer[s.length()]);
    }

    public Integer dfs(String s, int i, Integer[] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int result = dfs(s, i + 1, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && Character.digit(s.charAt(i + 1), 10) < 7))) {
            result += dfs(s, i + 2, dp);
        }
        dp[i] = result;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("226"));
    }
}
