package Chapter_14_2_D_Dynamic_Programming.lc_10_312_Burst_Balloons;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {
        return dfs(nums, new int[nums.length][nums.length], 0, nums.length - 1);
    }

    private int dfs(int[] nums, int[][] memo, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return 0;
        }
        if (memo[leftIndex][rightIndex] != 0) {
            return memo[leftIndex][rightIndex];
        }
        for (int i = leftIndex; i <= rightIndex; i++) {
            int coin = nums[i];
            if (leftIndex - 1 >= 0) {
                coin *= nums[leftIndex - 1];
            }
            if (rightIndex + 1 < nums.length) {
                coin *= nums[rightIndex + 1];
            }

            coin += dfs(nums, memo, leftIndex, i - 1) + dfs(nums, memo, i + 1, rightIndex);
            memo[leftIndex][rightIndex] = Math.max(memo[leftIndex][rightIndex], coin);
        }
        return memo[leftIndex][rightIndex];
    }

}
