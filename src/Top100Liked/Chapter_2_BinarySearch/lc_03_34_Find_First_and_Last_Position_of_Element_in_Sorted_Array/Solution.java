package Top100Liked.Chapter_2_BinarySearch.lc_03_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        int end = -1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    start = mid;
                    break;
                }
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (start == -1) {
            return new int[]{-1, -1};
        }
        left = start;
        right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                if (mid < nums.length - 1 && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    end = mid;
                    break;
                }
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0)));
    }
}
