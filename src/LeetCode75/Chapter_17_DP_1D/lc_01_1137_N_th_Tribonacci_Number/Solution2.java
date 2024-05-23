package LeetCode75.Chapter_17_DP_1D.lc_01_1137_N_th_Tribonacci_Number;

public class Solution2 {
    public int tribonacci(int n) {
         if (n == 0){
             return 0;
         }
         if (n <=2){
             return 1;
         }
         int[] memo = new int[n+1];
         memo[0] = 0;
         memo[1] = 1;
         memo[2] = 1;

         for (int i = 3; i<=n; i++){
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
         }
         return memo[n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.tribonacci(4));
    }
}
