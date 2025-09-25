package freeRun.lc_47_204_Count_Primes;

public class Solution {
    public int countPrimes(int n) {
        boolean[] map = new boolean[n];
        int count = 0;
        for (int i = 2; i < map.length; i++) {
            if (map[i]) {
                continue;
            }
            count++;
            for (long j = (long) i * i; j < n; j += i) {
                map[(int) j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }
}
