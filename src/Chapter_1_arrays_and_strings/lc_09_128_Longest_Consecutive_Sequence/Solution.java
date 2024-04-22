package Chapter_1_arrays_and_strings.lc_09_128_Longest_Consecutive_Sequence;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        int current = 1;
        int previous = 0;
        boolean needSkipFirst = true;
        for (Integer number : set) {
          if (needSkipFirst){
              previous = number;
              needSkipFirst = false;
              longest = 1;
              continue;
          }
          if (number == previous+1){
              current ++;
              longest = Math.max(longest, current);
          }
          else {
              current = 1;
          }
            previous = number;
        }
        return longest;
    }
}
