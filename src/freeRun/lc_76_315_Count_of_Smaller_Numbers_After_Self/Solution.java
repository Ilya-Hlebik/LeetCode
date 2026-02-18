package freeRun.lc_76_315_Count_of_Smaller_Numbers_After_Self;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {

        mergeSort(nums);
        return null;
    }

    private void mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int mid = nums.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[nums.length - mid];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < mid) {
                leftArray[i] = nums[i];
            } else {
                rightArray[j++] = nums[i];
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, nums);

    }

    private void merge(int[] leftArray, int[] rightArray, int[] nums) {
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < leftArray.length || r < rightArray.length) {
            if (l >= leftArray.length) {
                nums[i++] = rightArray[r++];
            } else if (r >= rightArray.length) {
                nums[i++] = leftArray[l++];
            } else if (leftArray[l] < rightArray[r]) {
                nums[i++] = leftArray[l++];
            } else {
                nums[i++] = rightArray[r++];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1, 3, 5, 4,0};
        solution.countSmaller(nums);
        System.out.println(Arrays.toString(nums));
    }


}
