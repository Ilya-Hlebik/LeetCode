package LeetCode75.Chapter_15_Binary_Search.lc_01_374_Guess_Number_Higher_or_Lower;

public class Solution {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while (l<=r){
            int mid = l + (r-l)/2;
           int res = guess(mid);
           if (res == 0){
               return mid;
           }
           if (res == -1){
               r = mid-1;
           }
           else {
               l = mid+1;
           }
        }
        return -1;
    }

    private int guess(int mid) {
        if (mid == 0){
            return 1;
        }
        else if (mid == 1){
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.guessNumber(1);
    }
}
