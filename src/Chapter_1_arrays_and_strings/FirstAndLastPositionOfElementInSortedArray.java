package Chapter_1_arrays_and_strings;

import java.util.Arrays;
/*You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.



Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]*/
public class FirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange1(int[] nums, int target) {
        int result[] = new int[]{-1,-1};
        boolean isFirst = true;
        for (int i = 0; i < nums.length; i++) {
            if (isFirst && target == nums[i]){
                result[0] = i;
                isFirst = false;
            }
            else if (target == nums[i]){
                result[1] = i;
            }
        }
        if (result [1] == -1){
            result [1] = result [0];
        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        FirstAndLastPositionOfElementInSortedArray firstAndLastPositionOfElementInSortedArray = new FirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.equals(firstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4}));
        System.out.println(Arrays.equals(firstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5,7,7,8,8,10}, 6), new int[]{-1,-1}));
        System.out.println(Arrays.equals(firstAndLastPositionOfElementInSortedArray.searchRange(new int[]{}, 0), new int[]{-1,-1}));

    }
}
