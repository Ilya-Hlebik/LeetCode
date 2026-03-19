package freeRun.lc_82_326_Power_of_Three;

public class Solution {
    public boolean isPowerOfThree(int n) {
        int pow = (int) Math.pow(3, 19);
        return n!=0 && pow % n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPowerOfThree(2147483647));
    }
}
