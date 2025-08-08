package freeRun.lc_32_168_Excel_Sheet_Column_Title;

import java.util.Stack;

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        if (columnNumber <= 26) {
            return Character.toString('A' + columnNumber - 1);
        }
        while (columnNumber > 26) {
            int remainder = columnNumber % 26;
            stack.push(remainder);
            columnNumber /= 26;
            if (columnNumber<=26) {
                stack.push(columnNumber);
            }
        }
        while (!stack.isEmpty()) {
            result.append(Character.toString('A' + stack.pop() - 1));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(52));
    }
}
