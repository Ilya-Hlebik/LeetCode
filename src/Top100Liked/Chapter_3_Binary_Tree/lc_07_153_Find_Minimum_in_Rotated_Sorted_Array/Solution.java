package Top100Liked.Chapter_3_Binary_Tree.lc_07_153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            min = Math.min(midVal, min);
            if ((nums[left] < midVal && nums[left] < nums[right]) || nums[right] > midVal) {
                right = mid - 1;
            }
            else {
                left = mid+1;
            }
        }
        return min;
    }
}
