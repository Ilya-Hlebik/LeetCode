package TopInterview150.Chapter_23_Multidimensional_DP.lc_05_97_Interleaving_String;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, s2, s3, 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean dfs(String s1, String s2, String s3, int index1, int index2, int index3, Boolean[][] memo) {
        if (index3 == s3.length()) {
            return true;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        boolean s1Equal = index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3);
        boolean s2Equal = index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3);
        if (s1Equal && s2Equal) {
            return memo[index1][index2] = dfs(s1, s2, s3, index1 + 1, index2, index3 + 1, memo) || dfs(s1, s2, s3, index1, index2 + 1, index3 + 1, memo);
        } else if (s1Equal) {
            return memo[index1][index2] = dfs(s1, s2, s3, index1 + 1, index2, index3 + 1, memo);
        } else if (s2Equal) {
            return memo[index1][index2] = dfs(s1, s2, s3, index1, index2 + 1, index3 + 1, memo);
        } else {
            return false;
        }
    }
}
