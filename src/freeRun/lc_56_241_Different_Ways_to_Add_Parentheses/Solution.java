package freeRun.lc_56_241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> diffWaysToCompute(String expression) {
        char[] charArray = expression.toCharArray();
        int currentNumber = 0;
        List<Integer> numbers = new ArrayList<>();
        List<Character> signs = new ArrayList<>();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else {
                numbers.add(currentNumber);
                currentNumber = 0;
                signs.add(c);
            }
        }
        compute(numbers, signs, 0, 0);
        numbers.add(currentNumber);
        return result;
    }

    private int compute(List<Integer> numbers, List<Character> signs, int i, int j) {
        if (i == numbers.size() - 1) {
            return numbers.get(i);
        }
        if (signs.get(j) == '+') {
            int i1 = numbers.get(i) + compute(numbers, signs, i + 1, j + 1);
            numbers.get(i) + numbers.get(i + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.diffWaysToCompute("2*2-4*5");
    }
}
