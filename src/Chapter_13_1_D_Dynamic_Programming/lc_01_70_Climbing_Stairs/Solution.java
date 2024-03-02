package Chapter_13_1_D_Dynamic_Programming.lc_01_70_Climbing_Stairs;

public class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    public int climbStairs(int n, int[] memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] == 0) {
            memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(44));
    }
}
