package stack.lc_01_20_Valid_Parentheses;

import java.util.Set;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Set<Character> closeParentheses = Set.of('}', ']', ')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentLetter = s.charAt(i);
            if (!closeParentheses.contains(currentLetter)) {
                stack.push(currentLetter);
            } else if (stack.isEmpty() ||!isOpposite(stack.pop(), currentLetter)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpposite(char letter1, char letter2) {
        switch (letter1) {
            case '(':
                return letter2 == ')';
            case '{':
                return letter2 == '}';
            default:
                return letter2 == ']';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("("));
        System.out.println(solution.isValid("(("));
    }
}
