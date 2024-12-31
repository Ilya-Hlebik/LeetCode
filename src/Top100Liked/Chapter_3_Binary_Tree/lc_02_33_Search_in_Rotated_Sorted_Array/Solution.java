package Top100Liked.Chapter_3_Binary_Tree.lc_02_33_Search_in_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }
            if (midVal < target && nums[left] < nums[right]) {
                left = mid + 1;
            } else if (midVal > target && nums[left] < nums[right]) {
                right = mid - 1;
            } else if (midVal < target && nums[left] > nums[right]) {
                if (nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (midVal > target && nums[left] > nums[right]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
