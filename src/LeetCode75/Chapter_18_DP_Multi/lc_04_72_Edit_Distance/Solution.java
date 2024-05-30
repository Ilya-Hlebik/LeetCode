package LeetCode75.Chapter_18_DP_Multi.lc_04_72_Edit_Distance;

public class Solution {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        return dfs(chars1, chars2, 0, 0, new Integer[word1.length()][word2.length()]);
    }

    private int dfs(char[] chars1, char[] chars2, int index1, int index2, Integer[][] memo) {
        if (index1 > chars1.length - 1 && index2 > chars2.length - 1) {
            return 0;
        } else if (index1 > chars1.length - 1) {
            return chars2.length - index2;
        } else if (index2 > chars2.length - 1) {
            return chars1.length - index1;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        int count = 0;
        if (chars1[index1] == chars2[index2]) {
            count += dfs(chars1, chars2, index1 + 1, index2 + 1, memo);
        } else {
            count += 1 + Math.min(dfs(chars1, chars2, index1 + 1, index2 + 1, memo),
                    Math.min(dfs(chars1, chars2, index1, index2 + 1, memo), dfs(chars1, chars2, index1 + 1, index2, memo)));
        }
        return memo[index1][index2] = count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
    }
}
