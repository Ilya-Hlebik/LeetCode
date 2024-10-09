package TopInterview150.Chapter_21_Math.lc_03_172_Factorial_Trailing_Zeroes;

public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        int multi = 5;
        while (true) {
            int temp = n / multi;
            res += temp;
            if (temp == 0) {
                return res;
            }
            multi *= 5;
        }
    }
}
