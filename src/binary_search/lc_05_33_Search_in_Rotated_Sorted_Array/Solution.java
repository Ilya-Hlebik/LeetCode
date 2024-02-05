package binary_search.lc_05_33_Search_in_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        return search(nums, target, min, max);
    }

    private int search(int[] nums, int target, int min, int max) {
        int result = -1;
        if (min > max) {
            return result;
        }
        int mid = min + (max - min) / 2;
        int midVal = nums[mid];
        if (midVal == target) {
            return mid;
        } else if (midVal >= nums[min]) {
            if (target > nums[mid] || target < nums[min]) {
                result = search(nums, target, mid + 1, max);
            } else {
                result = search(nums, target, min, mid - 1);
            }

        } else {
            if (target < midVal || target > nums[max]) {
                result = search(nums, target, min, mid - 1);
            } else {
                result = search(nums, target, mid + 1, max);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1}, 0));
        System.out.println(solution.search(new int[]{1}, 1));
        System.out.println(solution.search(new int[]{1, 3, 5}, 5));
        System.out.println(solution.search(new int[]{5, 1, 3}, 3));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(solution.search(new int[]{5, 1, 2, 3, 4}, 1));
    }
}
