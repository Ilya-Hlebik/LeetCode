package Chapter_15_Greedy.lc_03_45_Jump_Game_2;

public class Solution {

    public int jump(int[] nums) {
        return dfs(nums, 0, 0, new int[nums.length]);
    }

    private int dfs(int[] nums, int index, int jumps, int[] memo) {
        if (index > nums.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (index == nums.length - 1) {
            return jumps;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        memo[index] = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            memo[index] = Math.min(memo[index], dfs(nums, index + i, jumps + 1, memo));
        }
        return memo[index];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{1, 2, 1, 1, 1}));
    }
}
