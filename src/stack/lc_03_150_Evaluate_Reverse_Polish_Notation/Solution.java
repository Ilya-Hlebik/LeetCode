package stack.lc_03_150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 * pop1);
            } else if (token.equals("/")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 / pop1);
            } else if (token.equals("+")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 + pop1);
            } else if (token.equals("-")) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 - pop1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
