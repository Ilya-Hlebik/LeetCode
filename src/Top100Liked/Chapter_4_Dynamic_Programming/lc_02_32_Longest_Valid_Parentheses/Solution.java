package Top100Liked.Chapter_4_Dynamic_Programming.lc_02_32_Longest_Valid_Parentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        int newSize;
        int temp;
        int max = 0;
        for (int i = 2; i <= s.length(); i += 2) {
            for (int j = 0, k = i; k <= s.length() && max < i; j++, k++) {
                String substring = s.substring(j, k);
                newSize = substring.length();
                temp = 0;
                while (temp != newSize && newSize != 0) {
                    temp = newSize;
                    substring = substring.replace("()", "");
                    newSize = substring.length();
                }
                if (newSize == 0) {
                    max = i;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses(")()())");
    }
}
