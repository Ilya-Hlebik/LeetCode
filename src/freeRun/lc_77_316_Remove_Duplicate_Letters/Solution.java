package freeRun.lc_77_316_Remove_Duplicate_Letters;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] used = new boolean[26];
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (used[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && last[stack.peek() - 'a'] > i) {
                used[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            used[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }
}
