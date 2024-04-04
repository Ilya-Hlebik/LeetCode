package Chapter_13_1_D_Dynamic_Programming.lc_10_139_Word_Break;

import java.util.List;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("ddadddbdddadd", List.of("dd", "ad", "da", "b")));
    }


}
