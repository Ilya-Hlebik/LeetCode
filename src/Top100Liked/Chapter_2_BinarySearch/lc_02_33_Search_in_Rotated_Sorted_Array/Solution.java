package Top100Liked.Chapter_2_BinarySearch.lc_02_33_Search_in_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }
            if (nums[left] <= midVal) {
                if (target < midVal && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target < midVal || nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{5, 1, 2, 3, 4}, 1));
    }
}
