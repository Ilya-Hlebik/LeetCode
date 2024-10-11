package TopInterview150.Chapter_21_Math.lc_05_50_Pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
        double sign = x < 0 && n % 2 != 0 ? -1.0 : 1.0;
        double res = 1;
        int temp = n;
        x = Math.abs(x);
        if (n < 0) {
            while (temp++ < 0) {
                double temp1 = res;
                res *= x;
                if (Math.abs(res) == Double.POSITIVE_INFINITY || Math.abs(temp1) == Math.abs(res)) {
                    break;
                }
            }
        } else {
            while (temp-- > 0) {
                double temp1 = res;
                res *= x;
                if (Math.abs(res) == Double.POSITIVE_INFINITY || Math.abs(temp1) == Math.abs(res)) {
                    break;
                }
            }
        }
        if (n < 0) {
            return (double) 1 / res * sign;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(-1, -2147483648));
    }
}
