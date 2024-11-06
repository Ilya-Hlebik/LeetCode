package TopInterview150.Chapter_7_Stack.lc_05_224_Basic_Calculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<String> stackNumbers = new Stack<>();
        Stack<Boolean> inverse = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                number.append(c);
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    number.append(s.charAt(++i));
                }
                stackNumbers.add(number.toString());
            } else if (c != '(' && c != ')' && c != ' ') {
                if (!inverse.isEmpty() && inverse.peek()) {
                    if (c == '-') {
                        if (!stackNumbers.isEmpty() && (stackNumbers.peek().equals("-") || stackNumbers.peek().equals("+"))) {
                            stackNumbers.pop();
                        }
                        stackNumbers.push("+");
                    } else if (c == '+') {
                        stackNumbers.push("-");
                    }
                } else {
                    stackNumbers.push(String.valueOf(c));
                }
            } else if (c == '(') {
                inverse.push(!stackNumbers.isEmpty() && stackNumbers.peek().equals("-"));
            } else if (c == ')') {
                inverse.pop();
            }
        }
        int sum = 0;
        while (!stackNumbers.isEmpty()) {
            int firstNumber = Integer.parseInt(stackNumbers.pop());
            String sign = null;
            if (!stackNumbers.isEmpty()) {
                while (!stackNumbers.isEmpty() && (stackNumbers.peek().equals("+") || stackNumbers.peek().equals("-"))) {
                    String newSign = stackNumbers.pop();
                    if (sign == null) {
                        sign = newSign;
                    } else if (sign.equals("-") && newSign.equals("-")) {
                        sign = "+";
                    } else if (sign.equals("+") && newSign.equals("-")) {
                        sign = newSign;
                    }
                }
            } else {
                sign = "+";
            }
            if (sign.equals("-")) {
                sum -= firstNumber;
            } else {
                sum += firstNumber;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("- (3 - (- (4 + 5) ) )"));
    }
}
