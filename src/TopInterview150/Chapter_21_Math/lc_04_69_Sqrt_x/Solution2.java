package TopInterview150.Chapter_21_Math.lc_04_69_Sqrt_x;

public class Solution2 {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midVal = (long) mid * mid;
            if (midVal == x) {
                return mid;
            }
            if (midVal > x  ) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.mySqrt(2147395599));
    }
}
