package Top100Liked.Chapter_15_Misc.lc_01_31_Next_Permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int pivotIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivotIndex = i;
                break;
            }
        }
        if (pivotIndex==-1){
            for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = nums[i];
            if (cur > nums[pivotIndex]) {
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = cur;
                break;
            }
        }
        for (int i = pivotIndex + 1, j = nums.length - 1; j > i; j--, i++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[]{0, 1, 2, 5, 3, 3, 0};
        solution.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
