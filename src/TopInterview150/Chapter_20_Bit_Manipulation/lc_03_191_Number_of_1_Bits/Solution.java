package TopInterview150.Chapter_20_Bit_Manipulation.lc_03_191_Number_of_1_Bits;

public class Solution {
    public int hammingWeight(int n) {
        int count =0;
        for (int i = 0; i <= 31; i++) {
            if (((1 << i) & n )!=0) {
                count++;
            }
        }
        return count;
    }
}
