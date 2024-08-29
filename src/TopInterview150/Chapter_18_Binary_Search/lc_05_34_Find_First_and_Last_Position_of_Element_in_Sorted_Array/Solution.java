package TopInterview150.Chapter_18_Binary_Search.lc_05_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftRange = -1;
        int rightRange = -1;
        if (nums.length == 0) {
            return new int[]{leftRange, rightRange};
        }
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target) {
                if (mid - 1 >= 0 && nums[mid - 1] == target) {
                    max = mid - 1;
                    continue;
                } else {
                    leftRange = mid;
                    break;
                }
            }
            if (nums[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        min = 0;
        max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target) {
                if (mid + 1 < nums.length && nums[mid + 1] == target) {
                    min = mid + 1;
                    continue;
                } else {
                    rightRange = mid;
                    break;
                }
            }
            if (nums[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return new int[]{leftRange, rightRange};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1,1,2}, 1)));
    }
}
