package freeRun.lc_75_313_Super_Ugly_Number;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int uglyIndex = 1;
        while (uglyNumbers[n - 1] == 0) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < primes.length; i++) {
                int prime = primes[i];
                int candidate = prime * uglyNumbers[pointers[i]];
                if (candidate > 0) {
                    min = Math.min(candidate, min);
                }
            }
            uglyNumbers[uglyIndex++] = min;
            for (int i = 0; i < pointers.length; i++) {
                if (primes[i] * uglyNumbers[pointers[i]] == min) {
                    pointers[i]++;
                }
            }
        }
        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthSuperUglyNumber(5911, new int[]{2, 3, 5, 7}));
    }
}
