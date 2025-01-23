package Top100Liked.Chapter_4_Dynamic_Programming.lc_01_5_Longest_Palindromic_Substring;

public class Solution2 {
    public String longestPalindrome(String s) {
        int maxI = 0;
        int maxJ = 1;
        int maxSize = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0 && j > i; j--) {
                if ((j - i + 1) > maxSize) {
                    if (compare(chars, i, j)) {
                        maxSize = j - i + 1;
                        maxI = i;
                        maxJ = j + 1;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ);
    }

    private boolean compare(char[] chars, int i, int j) {
        while (j > i) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
