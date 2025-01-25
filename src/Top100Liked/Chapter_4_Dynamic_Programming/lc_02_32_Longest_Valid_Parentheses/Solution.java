package Top100Liked.Chapter_4_Dynamic_Programming.lc_02_32_Longest_Valid_Parentheses;

import java.util.LinkedList;

public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int left = -1;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.isEmpty()) {
                left = i;
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i - left);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("()(())"));
    }
}
