package TopInterview150.Chapter_23_Multidimensional_DP.lc_04_5_Longest_Palindromic_Substring;

public class Solution {
    public String longestPalindrome(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j + i < s.length(); j++) {
                if (compare(s, j, j + i)) {
                    return s.substring(j, j + i + 1);
                }
            }
        }
        return null;
    }

    public boolean compare(String s, int statIndex, int endIndex) {
        while (statIndex < endIndex) {
            if (s.charAt(statIndex++) != s.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
