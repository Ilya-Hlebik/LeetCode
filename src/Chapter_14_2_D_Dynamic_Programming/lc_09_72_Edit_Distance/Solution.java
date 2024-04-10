package Chapter_14_2_D_Dynamic_Programming.lc_09_72_Edit_Distance;

public class Solution {
    Integer memo[][];

    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int w1Index, int w2Index) {
        if (w1Index == word1.length() && w2Index == word2.length()) {
            return 0;
        }
        if (w1Index == word1.length() || w2Index == word2.length()) {
            return Math.max(word1.length() - w1Index, word2.length() - w2Index);
        }
        if (memo[w1Index][w2Index] != null) {
            return memo[w1Index][w2Index];
        }
        memo[w1Index][w2Index] = 0;
        if (word1.charAt(w1Index) == word2.charAt(w2Index)) {
            return memo[w1Index][w2Index] += dfs(word1, word2, w1Index + 1, w2Index + 1);
        } else {
            return memo[w1Index][w2Index] += 1 + Math.min(Math.min(dfs(word1, word2, w1Index + 1, w2Index),
                    dfs(word1, word2, w1Index + 1, w2Index + 1)), dfs(word1, word2, w1Index, w2Index + 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
    }
}
