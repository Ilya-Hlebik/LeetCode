package TopInterview150.Chapter_7_Stack.lc_04_150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if (token.equals("-")){
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first-second);
            }
            else if (token.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if (token.equals("/")){
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first/second);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
