package TopInterview150.Chapter_18_Binary_Search.lc_03_162_Find_Peak_Element;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int l = 1;
        int r = nums.length - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            if (nums[mid] < nums[mid-1]){
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
    }
}