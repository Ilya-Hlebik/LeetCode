package LeetCode75.Chapter_17_DP_1D.lc_04_790_Domino_and_Tromino_Tiling;

public class Solution {
    public int numTilings(int n) {

        int mod = 1_000_000_007;
        long[] res = new long[n + 3];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = ((2 * res[i - 1]) + res[i - 3]) % mod;
        }
        return (int) res[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numTilings(4);
    }

}
