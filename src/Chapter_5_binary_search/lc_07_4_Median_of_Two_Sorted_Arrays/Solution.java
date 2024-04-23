package Chapter_5_binary_search.lc_07_4_Median_of_Two_Sorted_Arrays;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int sumOfLength = nums1Length + nums2Length;
        int firsIndex = sumOfLength / 2;
        int secondIndex = firsIndex - 1;
        boolean need2Numbers = false;
        if (sumOfLength % 2 == 0) {
            need2Numbers = true;
        }
        int nums1Start = 0;
        int nums2Start = 0;
        List<Integer> combinedElements = new ArrayList<>();
        while (nums1Start < nums1Length || nums2Start < nums2Length) {
            if (nums1Start < nums1Length && (nums2Start >= nums2Length || nums1[nums1Start] < nums2[nums2Start])) {
                combinedElements.add(nums1[nums1Start++]);
            } else {
                combinedElements.add(nums2[nums2Start++]);
            }

            if (combinedElements.size() > firsIndex) {
                if (need2Numbers) {
                    return (double) (combinedElements.get(firsIndex) + combinedElements.get(secondIndex)) / 2;
                } else {
                    return (double) (combinedElements.get(firsIndex));
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }
}
