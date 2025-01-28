package Top100Liked.Chapter_4_Dynamic_Programming.lc_06_72_Edit_Distance;

public class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0, new Integer[word1.length() + 1][word2.length() + 1]);
    }

    public int dfs(String word1, String word2, int index1, int index2, Integer[][] memo) {
        if (index1 > (word1.length() - 1) && index2 > (word2.length() - 1)) {
            return 0;
        }
        if (index1 > (word1.length() - 1)) {
            return word2.length() - index2;
        }
        if (index2 > (word2.length() - 1)) {
            return word1.length() - index1;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return memo[index1][index2] = dfs(word1, word2, index1 + 1, index2 + 1, memo);
        } else {
            return memo[index1][index2] = 1 + Math.min(Math.min(dfs(word1, word2, index1 + 1, index2, memo),
                    dfs(word1, word2, index1, index2 + 1, memo)), dfs(word1, word2, index1 + 1, index2 + 1, memo));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("sea", "eat"));
    }
}
