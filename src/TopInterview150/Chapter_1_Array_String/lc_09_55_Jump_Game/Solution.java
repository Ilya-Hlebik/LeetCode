package TopInterview150.Chapter_1_Array_String.lc_09_55_Jump_Game;

public class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0, new Boolean[nums.length]);
    }

    boolean dfs(int[] nums, int index, Boolean memo[]) {
        if (index == nums.length - 1) {
            return true;
        }
        if (index > nums.length - 1) {
            return false;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        boolean canJump = false;
        for (int i = 1; i <= nums[index]; i++) {
            canJump = dfs(nums, index + i, memo);
            if (canJump) {
                break;
            }
        }
        return memo[index] = canJump;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
