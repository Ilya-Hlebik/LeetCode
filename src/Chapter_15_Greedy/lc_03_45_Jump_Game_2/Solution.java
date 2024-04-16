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
        if (memo[index] != 0 && memo[index]!= Integer.MAX_VALUE && memo[index] < jumps) {
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
        System.out.println(solution.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
