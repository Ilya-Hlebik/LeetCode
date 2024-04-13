package Chapter_15_Greedy.lc_02_55_Jump_Game;

public class Solution {

    public boolean canJump(int[] nums) {
        return dfs(nums, 0, new Boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int index, Boolean[] memo) {
        if (index > nums.length - 1) {
            return false;
        }
        if (index == nums.length - 1) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (dfs(nums, index + i, memo)) {
                return true;
            }
        }
        memo[index] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
