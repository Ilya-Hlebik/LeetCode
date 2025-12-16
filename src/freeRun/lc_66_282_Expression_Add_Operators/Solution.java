package freeRun.lc_66_282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        ArrayList<String> result = new ArrayList<>();
        dfs(num, target, result, "", 0, 0, 0);
        return result;
    }

    public void dfs(String num, int target, List<String> result, String current, int pos, long currentTotal, long lastOperand) {
        if (pos == num.length() && currentTotal == target) {
            result.add(current);
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                return;
            }
            String substring = num.substring(pos, i + 1);
            long currentNumber = Long.parseLong(substring);
            if (pos == 0) {
                dfs(num, target, result, substring, i + 1, currentNumber, currentNumber);
            } else {
                dfs(num, target, result, current + "+" + substring, i + 1, currentTotal + currentNumber, currentNumber);
                dfs(num, target, result, current + "*" + substring, i + 1, (currentTotal - lastOperand) + lastOperand * currentNumber, lastOperand * currentNumber);
                dfs(num, target, result, current + "-" + substring, i + 1, currentTotal - currentNumber, -currentNumber);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addOperators("3456237490", 9191);
    }
}
