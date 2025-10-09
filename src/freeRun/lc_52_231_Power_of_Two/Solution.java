package freeRun.lc_52_231_Power_of_Two;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        double x = Math.log(n) / Math.log(2);
        return Math.pow(2, Math.round(x)) == n ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(536870912));
    }
}
