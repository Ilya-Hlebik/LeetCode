package TopInterview150.Chapter_23_Multidimensional_DP.lc_06_72_Edit_Distance;

public class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0, new Integer[word1.length() + 1][word2.length() + 1]);
    }

    public int dfs(String word1, String word2, int index1, int index2, Integer[][] memo) {
        if (index1 == word1.length() && index2 == word2.length()) {
            return 0;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        boolean bothInBegin = index1 < word1.length() && index2 < word2.length();
        int res = 0;
        if (bothInBegin && word1.charAt(index1) == word2.charAt(index2)) {
            res += dfs(word1, word2, index1 + 1, index2 + 1, memo);
        } else if (bothInBegin && word1.charAt(index1) != word2.charAt(index2)) {
            res += 1 + Math.min(dfs(word1, word2, index1, index2 + 1, memo),
                    Math.min(dfs(word1, word2, index1 + 1, index2 + 1, memo),
                            dfs(word1, word2, index1 + 1, index2, memo)));
        } else if (index1 < word1.length()) {
            res += word1.length() - index1;
        } else {
            res += word2.length() - index2;
        }
        return memo[index1][index2] = res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //1
        System.out.println(solution.minDistance("park", "spake"));
    }
}
