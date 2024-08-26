package TopInterview150.Chapter_18_Binary_Search.lc_04_133_Search_in_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }
            if (midVal >= nums[l]) {
                if (target > midVal || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < midVal || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
