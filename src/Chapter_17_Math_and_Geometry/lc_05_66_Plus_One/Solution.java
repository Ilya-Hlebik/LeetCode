package Chapter_17_Math_and_Geometry.lc_05_66_Plus_One;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            int temp = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int value = (digits[i] + temp) % 10;
                temp = (digits[i] + temp) / 10;
                res[i + 1] = value;
            }
            if (temp != 0) {
                res[0] = temp;
                return res;
            }
            return Arrays.copyOfRange(res, 1, res.length);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{8, 9, 9, 9})));
    }
}
