package binary_search.lc_04_153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.findMin(new int[]{11, 13, 15, 17}));
        System.out.println(solution.findMin(new int[]{2, 1}));
    }

    public int findMin(int[] nums) {
        int minResult = nums[0];
        int min = 1;
        int max = nums.length - 1;
        while (max >= min) {
            int mid = min + (max - min) / 2;
            int midRes = nums[mid];
            if (midRes > minResult) {
                //go right
                min = mid + 1;
            } else {
                minResult = midRes;
                max = mid - 1;
            }

        }
        return minResult;
    }
}
