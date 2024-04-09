package Chapter_14_2_D_Dynamic_Programming.lc_06_97_Interleaving_String;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() > s3.length()) {
            return false;
        }
        return dfs(s1, s2, s3, 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean dfs(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index, Boolean[][] memo) {
        if (s3Index >= s3.length()) {
            return memo[s1Index][s2Index] = true;
        }
        if (memo[s1Index][s2Index] != null) {
            return memo[s1Index][s2Index];
        }
        boolean s1EqualsS3 = s1Index <= s1.length() - 1 && s1.charAt(s1Index) == s3.charAt(s3Index);
        boolean s2EqualsS3 = s2Index <= s2.length() - 1 && s2.charAt(s2Index) == s3.charAt(s3Index);
        if (s1EqualsS3 && s2EqualsS3) {
            return memo[s1Index][s2Index] = dfs(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, memo) ||
                    dfs(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, memo);
        } else if (s1EqualsS3) {
            return memo[s1Index][s2Index] = dfs(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, memo);
        } else if (s2EqualsS3) {
            return memo[s1Index][s2Index] = dfs(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, memo);
        } else {
            return memo[s1Index][s2Index] = false;
        }
    }
}
