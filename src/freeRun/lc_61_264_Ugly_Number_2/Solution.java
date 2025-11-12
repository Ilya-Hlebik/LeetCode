package freeRun.lc_61_264_Ugly_Number_2;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] numbers = new int[n];
        numbers[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 0; i < numbers.length; i++) {
            int min = Math.min(next2, Math.min(next3, next5));
            numbers[i] = min;
            if (min == next2) {
                next2 = numbers[++p2] * 2;
            }
            if (min == next3) {
                next3 = numbers[++p3] * 3;
            }
            if (min == next5) {
                next5 = numbers[++p5] * 5;
            }
        }
        return numbers[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}
