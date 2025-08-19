package freeRun.lc_34_174_Dungeon_Game;

public class Solution2 {

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[dp.length-1][dp[0].length-2] = 1;
        dp[dp.length-2][dp[0].length-1] = 1;
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[i].length - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(solution.calculateMinimumHP(dungeon));
    }
}
