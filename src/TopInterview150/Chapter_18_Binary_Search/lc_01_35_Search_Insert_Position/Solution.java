package TopInterview150.Chapter_18_Binary_Search.lc_01_35_Search_Insert_Position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            }
            if (midValue > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1,2,4,6,7};
        System.out.println(solution.searchInsert(ints, 3));
    }
}
