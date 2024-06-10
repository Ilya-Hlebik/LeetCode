package TopInterview150.Chapter_1_Array_String.lc_11_274_H_Index;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int citation : citations) {
            if (citation > citations.length - 1) {
                buckets[citations.length]++;
            } else {
                buckets[citation]++;
            }
        }
        int count = 0;
        for (int i = citations.length; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
