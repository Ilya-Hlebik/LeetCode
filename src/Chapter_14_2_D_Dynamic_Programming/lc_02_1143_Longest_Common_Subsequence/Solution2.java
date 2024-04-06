package Chapter_14_2_D_Dynamic_Programming.lc_02_1143_Longest_Common_Subsequence;

public class Solution2 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] solution = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            char char1 = text1.charAt(i);
            for (int j = text2.length() - 1; j >= 0; j--) {
                char char2 = text2.charAt(j);
                if (char1 == char2) {
                    solution[i][j] = 1 + solution[i + 1][j + 1];
                } else {
                    solution[i][j] = Math.max(solution[i][j + 1], solution[i + 1][j]);
                }
            }
        }
        return solution[0][0];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }
}
