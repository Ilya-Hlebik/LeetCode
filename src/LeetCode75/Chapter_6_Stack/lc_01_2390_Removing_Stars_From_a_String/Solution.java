package LeetCode75.Chapter_6_Stack.lc_01_2390_Removing_Stars_From_a_String;

import java.util.Stack;

public class Solution {
    public String removeStars(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char letter : chars) {
            if (letter == '*') {
                stack.pop();
            } else {
                stack.push(letter);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeStars("leet**cod*e");
    }
}
