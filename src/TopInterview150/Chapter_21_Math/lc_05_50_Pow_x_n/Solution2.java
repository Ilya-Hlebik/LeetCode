package TopInterview150.Chapter_21_Math.lc_05_50_Pow_x_n;

public class Solution2 {
    public double myPow(double x, int n) {
        double res = helper(x,  n );
        return n < 0 ? 1 / res : res;
    }

    private double helper(double x, int n) {
        if (x == 1.0 || x == 0.0) {
            return x;
        }
        if (n == 0){
            return 1;
        }
        if (Math.abs(n) == 1){
            return x;
        }
        if (n%2==0){
            return helper(x * x, n/2);
        }
        else {
            return x * helper(x*x, n/2);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.myPow(2.0, -2147483648));
    }
}
