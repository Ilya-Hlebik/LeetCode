package Top100Liked.Chapter_2_BinarySearch.lc_01_4_Median_of_Two_Sorted_Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int firstIndex = totalSize / 2;
        int secondIndex = totalSize % 2 == 0 ? firstIndex - 1 : firstIndex;
        int firstValue = 0;
        int secondValue = 0;
        for (int i = 0, j = 0, k = 0; i < totalSize; i++) {
            if (k >= nums2.length || j < nums1.length && nums1[j] <= nums2[k]) {
                if (i == firstIndex) {
                    firstValue = nums1[j];
                }
                if (i == secondIndex) {
                    secondValue = nums1[j];
                }
                j++;
            } else if (j >= nums1.length || nums1[j] >= nums2[k]) {
                if (i == firstIndex) {
                    firstValue = nums2[k];
                }
                if (i == secondIndex) {
                    secondValue = nums2[k];
                }
                k++;
            }
            if (i == firstIndex) {
                break;
            }
        }
        return (double) (firstValue + secondValue) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
