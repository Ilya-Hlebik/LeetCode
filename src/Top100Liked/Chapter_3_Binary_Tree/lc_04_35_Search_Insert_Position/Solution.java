package Top100Liked.Chapter_3_Binary_Tree.lc_04_35_Search_Insert_Position;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (target>nums[nums.length-1]){
            return nums.length;
        }
        if (target<nums[0]){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = nums[mid];
            if (midVal==target){
                return mid;
            }
            if (midVal > target) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3}, 2));

    }
}
