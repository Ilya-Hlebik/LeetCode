package freeRun.lc_60_263_Ugly_Number;

public class Solution2 {
    public boolean isUgly(int n) {
        long number = Math.abs((long)n);
        while (number > 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else if (number % 3 == 0) {
                number /= 3;
            } else if (number % 5 == 0) {
                number /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isUgly(-2147483648));
    }
}
