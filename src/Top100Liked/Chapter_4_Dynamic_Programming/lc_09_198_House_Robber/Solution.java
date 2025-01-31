package Top100Liked.Chapter_4_Dynamic_Programming.lc_09_198_House_Robber;

public class Solution {
    public int rob(int[] nums) {
        return dfs(nums, 0,  new Integer[nums.length + 1]);
    }

    public int dfs(int[] nums, int index,   Integer[] memo) {
        if (index > nums.length - 1) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        return memo[index] = Math.max(nums[index] + dfs(nums, index + 2, memo), dfs(nums, index + 1, memo));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,1,1}));
    }
}
