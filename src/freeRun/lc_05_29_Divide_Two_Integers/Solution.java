package freeRun.lc_05_29_Divide_Two_Integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        int c = dividend < 0 && divisor > 0 || dividend >= 0 && divisor < 0 ? -1 : 1;
        long dd = Math.abs((long) dividend);
        long dr = Math.abs(divisor);
        if (divisor == 1) {
            return dividend;
        }
        long res = 0;
        for (int i = 30; i >= 0; i--) {
            long temp = dr << i;
            if (temp <= dd) {
                res += (1 << i);
                dd -= temp;
            }
        }
        return (int) (c < 0 ? -res : res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648, -1));
    }
}
