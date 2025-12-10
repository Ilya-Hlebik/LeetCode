package freeRun.lc_64_278_First_Bad_Version;

public class Solution {
    public int firstBadVersion(int n) {
        int response = 0;
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                response = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return response;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
