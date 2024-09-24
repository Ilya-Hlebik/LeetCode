package TopInterview150.Chapter_18_Binary_Search.lc_07_4_Median_of_Two_Sorted_Arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int index1 = 0;
        int index2 = 0;
        int desiredIndex1 = (total - 1) / 2;
        int desiredIndex2 = total % 2 != 0 ? -1 : total / 2;
        double firstValue = 0.0;
        for (int i = 0; i < total; i++) {
            int currentValue = 0;
            if (index1 > nums1.length - 1 || (index2 < nums2.length && nums2[index2] <= nums1[index1])) {
                currentValue = nums2[index2++];
            } else {
                currentValue = nums1[index1++];
            }
            if (i == desiredIndex1) {
                if (desiredIndex2 == -1) {
                    return currentValue;
                } else {
                    firstValue = currentValue;
                }
            }
            if (i == desiredIndex2) {
                return (firstValue + currentValue) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
