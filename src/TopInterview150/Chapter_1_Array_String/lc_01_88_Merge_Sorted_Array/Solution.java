package TopInterview150.Chapter_1_Array_String.lc_01_88_Merge_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0 && n > 0; i--) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                int temp = nums1[i];
                nums1[i] = nums1[m - 1];
                nums1[m - 1] = temp;
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {0};
        solution.merge(nums1, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
