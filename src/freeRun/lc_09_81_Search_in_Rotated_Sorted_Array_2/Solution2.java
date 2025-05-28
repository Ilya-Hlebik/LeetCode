package freeRun.lc_09_81_Search_in_Rotated_Sorted_Array_2;

public class Solution2 {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            while (l < r && nums[l + 1] == nums[l]) {
                l++;
            }
            while (r > 0 && nums[r - 1] == nums[r]) {
                r--;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target<= nums[r]){
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.search(new int[]{3, 1}, 1));
    }
}
