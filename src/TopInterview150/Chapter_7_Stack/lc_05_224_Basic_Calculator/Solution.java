package TopInterview150.Chapter_7_Stack.lc_05_224_Basic_Calculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        if (s.trim().matches("^[0-9]*$")) {
            return Integer.parseInt(s.trim());
        }
        Stack<String> stackNumbers = new Stack<>();
        Stack<Boolean> inverse = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {

            } else if (c != '(' && c != ')' && c != ' ') {
                if (!inverse.isEmpty() && inverse.peek()) {
                    if (c == '-') {
                        if (!stackNumbers.isEmpty() && (stackNumbers.peek() == '-' || stackNumbers.peek() == '+')) {
                            stackNumbers.pop();
                        }
                        stackNumbers.push('+');
                    } else if (c == '+') {
                        stackNumbers.push('-');
                    }
                } else {
                    stackNumbers.push(c);
                }
            } else if (c == '(') {
                inverse.push(!stackNumbers.isEmpty() && stackNumbers.peek() == '-');
            } else if (c == ')') {
                inverse.pop();
            }
        }
        int sum = 0;
        while (!stackNumbers.isEmpty()) {
            int firstNumber = Character.digit(stackNumbers.pop(), 10);
            Character sign;
            if (!stackNumbers.isEmpty()) {
                sign = stackNumbers.pop();
            } else {
                sign = '+';
            }
            if (sign == '-') {
                sum -= firstNumber;
            } else {
                sum += firstNumber;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1-11"));
    }
}
