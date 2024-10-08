package TopInterview150.Chapter_21_Math.lc_02_66_Plus_One;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        List<Integer> list = new ArrayList<>();
        int left = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = left + digits[i];
            list.add(0, val % 10);
            left = val/10;
        }
        if (left!=0){
            list.add(0, left);
        }
        return list.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.plusOne(new int[]{9});
    }
}
