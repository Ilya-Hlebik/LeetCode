package TopInterview150.Chapter_18_Binary_Search.lc_06_153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            min = Math.min(nums[mid], min);
            if (min < nums[r] || (nums[l] < min && nums[l] < nums[r])) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.findMin(new int[]{5, 1, 2, 3, 4}));

    }
}
