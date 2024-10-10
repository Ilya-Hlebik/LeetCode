package TopInterview150.Chapter_21_Math.lc_04_69_Sqrt_x;

public class Solution {
    public int mySqrt(int x) {
        if (x ==1){
            return x;
        }
        for (int i = Math.min(x / 2, 46340); i >= 0; i--) {
            if (i * i <= x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}
