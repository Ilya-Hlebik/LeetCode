package freeRun.lc_09_81_Search_in_Rotated_Sorted_Array_2;

public class Solution {
    public boolean search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                while (l + 1 < r && nums[l] == nums[l + 1]) {
                    l++;
                }
                while (l <= r - 1 && nums[r] == nums[r - 1]) {
                    r--;
                }
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[l] <= nums[mid]) {
                    if (target < nums[mid]  && nums[l] <= target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (target < nums[mid] || nums[r] < target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{3,1}, 1));
    }
}
