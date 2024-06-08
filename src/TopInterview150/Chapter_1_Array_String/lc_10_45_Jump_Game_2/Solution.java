package TopInterview150.Chapter_1_Array_String.lc_10_45_Jump_Game_2;

public class Solution {
    public int jump(int[] nums) {
        return dfs(nums, 0, new Integer[nums.length][nums.length], 0);
    }

    int dfs(int[] nums, int index, Integer[][] memo, int count) {
        if (index == nums.length - 1) {
            return count;
        }
        if (index > nums.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (memo[index][count] != null) {
            return memo[index][count];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            min = Math.min(min, dfs(nums, index + i, memo, count + 1));
        }
        return memo[index][count] = Math.toIntExact(min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{1,2,1,1,1}));
    }
}
