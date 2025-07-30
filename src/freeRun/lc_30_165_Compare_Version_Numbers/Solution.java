package freeRun.lc_30_165_Compare_Version_Numbers;

public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version2.equals(version1)) {
            return 0;
        }
        int size1 = version1.length();
        int b1 = 0;
        int b2 = 0;
        int e1 = 0;
        int e2 = 0;
        int size2 = version2.length();
        while (b1 < size1 || b2 < size2) {
            while (e1 < size1 && version1.charAt(e1) != '.') {
                e1++;
            }
            int temp1 = b1 >= size1 ? 0 : Integer.parseInt(version1.substring(b1, e1));
            while (e2 < size2 && version2.charAt(e2) != '.') {
                e2++;
            }
            int temp2 = b2 >= size2 ? 0 : Integer.parseInt(version2.substring(b2, e2));

            if (temp1 < temp2) {
                return -1;
            } else if (temp1 > temp2) {
                return 1;
            }
            b1 = ++e1;
            b2 = ++e2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("1.1", "1.0.0.1"));
    }
}
