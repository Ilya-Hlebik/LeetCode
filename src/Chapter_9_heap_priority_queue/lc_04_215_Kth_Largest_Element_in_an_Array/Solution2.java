package Chapter_9_heap_priority_queue.lc_04_215_Kth_Largest_Element_in_an_Array;

import java.util.Arrays;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
