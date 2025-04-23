package Top100Liked.Chapter_13_Two_Pointers.lc_04_283_Move_Zeroes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.add(i);
            } else if (!queue.isEmpty()) {
                Integer poll = queue.poll();
                int temp = nums[poll];
                nums[poll] = nums[i];
                nums[i] = temp;
                queue.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
