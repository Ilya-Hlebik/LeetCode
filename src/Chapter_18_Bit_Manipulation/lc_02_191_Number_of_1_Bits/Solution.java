package Chapter_18_Bit_Manipulation.lc_02_191_Number_of_1_Bits;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.hammingWeight(12);
    }
    public int hammingWeight(int n) {
        int i = Integer.bitCount(n);
        System.out.println(i);
        return 0;
    }
}
