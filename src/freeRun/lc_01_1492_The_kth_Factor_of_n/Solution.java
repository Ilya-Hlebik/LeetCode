package freeRun.lc_01_1492_The_kth_Factor_of_n;

public class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }
        return k==1?n:-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthFactor(4, 4));
    }
}
