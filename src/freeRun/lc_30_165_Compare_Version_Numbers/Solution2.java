package freeRun.lc_30_165_Compare_Version_Numbers;

public class Solution2 {
    public int compareVersion(String version1, String version2) {
        if (version2.equals(version1)) {
            return 0;
        }
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < split1.length || j < split2.length) {
            int temp1 = i < split1.length? Integer.parseInt(split1[i++]): 0;
            int temp2 = j < split2.length? Integer.parseInt(split2[j++]): 0;
            if (temp1 < temp2) {
                return -1;
            } else if (temp1 > temp2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.compareVersion("1.1", "1.0.0.1"));
    }
}
