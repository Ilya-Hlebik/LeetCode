package freeRun.lc_63_275_H_Index_2;

public class Solution {
    public int hIndex(int[] citations) {
        int response = 0;
        int l = 0;
        int r = citations.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = citations[mid];
            int n = citations.length - mid;
            if (midVal >= n) {
                response = n;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return response;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{ 7, 8, 9, 15, 20, 30, 33}));
    }
}
