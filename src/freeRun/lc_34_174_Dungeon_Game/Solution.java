package freeRun.lc_34_174_Dungeon_Game;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        return dfs(dungeon, 0, 0, new Integer[dungeon.length][dungeon[0].length]);
    }

    private int dfs(int[][] dungeon, int x, int y, Integer[][] memo) {
        if (x > dungeon.length - 1 || y > dungeon[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        if (memo[x][y] != null) {
            return memo[x][y];
        }
        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
            return Math.max(1, 1 - dungeon[x][y]);
        }
        return memo[x][y] = Math.max(1, Math.min(dfs(dungeon, x + 1, y, memo), dfs(dungeon, x, y + 1, memo)) - dungeon[x][y]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(solution.calculateMinimumHP(dungeon));
    }
}
