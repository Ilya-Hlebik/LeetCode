package Chapter_17_Math_and_Geometry.lc_06_50_Pow_x_n;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        double res = helper(x, Math.abs((long) n));
        return n < 0 ? 1 / res : res;
    }

    private double helper(double x, long n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return x * helper(x * x, n / 2);
        }
    }
}
