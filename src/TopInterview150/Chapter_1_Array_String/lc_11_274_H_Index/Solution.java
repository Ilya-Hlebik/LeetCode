package TopInterview150.Chapter_1_Array_String.lc_11_274_H_Index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1;
        int times = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            if (citations[i] <= citations.length) {
                h = citations[i];
                times = Math.max(citations.length - i, times);
            }
        }
        return times;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{1,3,1}));
    }
}
