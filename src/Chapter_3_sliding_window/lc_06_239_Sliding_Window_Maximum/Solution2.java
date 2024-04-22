package Chapter_3_sliding_window.lc_06_239_Sliding_Window_Maximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!que.isEmpty() && que.peekFirst() <= i - k) {
                que.pollFirst();
            }
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()]){
                que.pollLast();
            }
            que.offer(i);
            if (i >= k-1){
                result[resultIndex++] = nums[que.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
