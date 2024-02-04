package binary_search.lc_01_704_Binary_Search;

public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int min, int max) {
        if (min > max) {
            return -1;
        }
        int mid = min + (max - min) / 2;
        int midValue = nums[mid];
        if (midValue == target) {
            return mid;
        }
        if (midValue > target) {
            return search(nums, target, min, mid - 1);
        }
        return search(nums, target, mid + 1, max);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 1));
    }
}
