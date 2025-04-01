package Top100Liked.Chapter_11_Sliding_Window.lc_03_239_Sliding_Window_Maximum;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int compare = Integer.compare(o2[0], o1[0]);
            if (compare == 0) {
                return Integer.compare(o2[1], o1[1]);
            }
            return compare;
        });
        int[] res = new int[nums.length - k + 1];
        for (int r = 0, i = 0; r < nums.length; r++) {
            queue.add(new int[]{nums[r], r});
            if (queue.size() < k) {
                continue;
            }
            while (queue.peek()[1] < r - k + 1) {
                queue.poll();
            }
            res[i] = queue.peek()[0];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, -9, 8, -6, 6, 4, 0, 5}, 4)));
    }
}
