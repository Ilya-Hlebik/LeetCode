package TopInterview150.Chapter_1_Array_String.lc_06_189_Rotate_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        List<Integer> tempList = new ArrayList<>();
        for (int num : nums) {
            tempList.add(num);
        }
        for (int i = 0; i < tempList.size(); i++) {
            nums[(i + k) % (nums.length)] = tempList.get(i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
