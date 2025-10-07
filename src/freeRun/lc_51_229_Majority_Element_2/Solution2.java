package freeRun.lc_51_229_Majority_Element_2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count2 = count1 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.majorityElement(new int[]{0,0,0});
    }
}
