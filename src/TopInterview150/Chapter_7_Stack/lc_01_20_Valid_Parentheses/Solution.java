package TopInterview150.Chapter_7_Stack.lc_01_20_Valid_Parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            }
            else if (stack.isEmpty()){
                return false;
            }
            else {
                Character pop = stack.pop();
                if (pop == '(' && c !=')' || pop == '[' && c !=']'|| pop == '{' && c !='}'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
