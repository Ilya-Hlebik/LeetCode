package Top100Liked.Chapter_12_Stack.lc_01_20_Valid_Parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character poped = stack.pop();
                if (c == ')' && poped != '(' || c == ']' && poped != '[' || c == '}' && poped != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
