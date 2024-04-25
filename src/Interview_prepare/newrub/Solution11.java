package Interview_prepare.newrub;

public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] memo = new int[5 + 1];
        System.out.println(solution11.fib(5, memo));
        System.out.println();
    }

    public int fib(int i, int memo[]) {
        if (i <= 0) {
            return 0;
        }
        if (memo[i]!=0){
            return memo[i];
        }
        if (i == 1) {
            memo[i] = 1;
            return 1;
        }
        memo[i] = fib(i - 1, memo) + fib(i - 2, memo);
        return memo[i];
    }
}
