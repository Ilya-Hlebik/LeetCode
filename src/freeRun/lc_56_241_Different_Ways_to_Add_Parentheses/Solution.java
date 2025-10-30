package freeRun.lc_56_241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) return map.get(expression);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String leftString = expression.substring(0, i);
                String rightString = expression.substring(i+1);
                List<Integer> left = diffWaysToCompute(leftString);
                List<Integer> right = diffWaysToCompute(rightString);
                for (Integer l : left) {
                    for (Integer r : right) {
                        result.add(combine(l, r, c));
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        map.put(expression, result);
        return result;
    }

    private Integer combine(Integer l, Integer r, char c) {
        if (c == '+') {
            return l + r;
        }
        if (c == '-') {
            return l - r;
        } else {
            return l * r;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
}
