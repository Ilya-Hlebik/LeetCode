package Chapter_17_Math_and_Geometry.lc_05_66_Plus_One;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 0; i--) {
                res[i+1] = digits[i];
            }
            for (int i = res.length - 1; i >= 0; i--) {
                if (i == 0 && res[i] == 9) {
                    res[0] = 1;
                    res[1] = 0;
                    return res;
                }
                if (res[i] == 9) {
                    res[i] = 0;
                } else {
                    res[i]++;
                    break;
                }
            }
            return Arrays.copyOfRange(res, 1, res.length+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9})));
    }
}
