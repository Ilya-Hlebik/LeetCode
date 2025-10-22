package freeRun.lc_54_233_Number_of_Digit_One;

public class Solution {
    public int countDigitOne(int n) {
        int factor = 1;
        int count = 0;
        while (n / factor > 0) {
            int higher = n / (factor * 10);
            int lower = n % factor;
            int current = n / (factor) % 10;
            if (current == 0) {
                count += (higher * factor);
            } else if (current == 1) {
                count += (higher * factor + (lower + 1));
            } else if (current >= 2) {
                count += (factor * (higher + 1));
            }
            factor *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(13));
    }
}
