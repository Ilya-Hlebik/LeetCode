package freeRun.lc_50_227_Basic_Calculator_2;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int currentNum = 0;
        char lastOperator = '+';
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c != ' ') {
                compute(currentNum, lastOperator, stack);
                currentNum = 0;
                lastOperator = c;
            }
        }
        compute(currentNum, lastOperator, stack);
        return stack.stream().mapToInt(el -> el).sum();
    }

    private static void compute(int num, char lastOperator, Stack<Integer> stack) {
        if (lastOperator == '+') {
            stack.push(num);
        } else if (lastOperator == '-') {
            stack.push(-num);
        } else if (lastOperator == '*') {
            stack.push(stack.pop() * num);
        } else {
            stack.push(stack.pop() / num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("21+5*2/4-7*3+1/4"));
    }
}
