package Top100Liked.Chapter_15_Misc.lc_08_189_Rotate_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % (nums.length)] = list.get(i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
