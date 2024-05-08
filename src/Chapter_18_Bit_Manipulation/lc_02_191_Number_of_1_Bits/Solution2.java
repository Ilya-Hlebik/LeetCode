package Chapter_18_Bit_Manipulation.lc_02_191_Number_of_1_Bits;


public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.hammingWeight(12));
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += ((1 << i) & n) != 0 ? 1 : 0;
        }
        return count;
    }
}
