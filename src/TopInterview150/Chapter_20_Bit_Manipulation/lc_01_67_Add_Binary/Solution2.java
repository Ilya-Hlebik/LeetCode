package TopInterview150.Chapter_20_Bit_Manipulation.lc_01_67_Add_Binary;

public class Solution2 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int cary = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; ) {
            int sum = cary;
            if (i >= 0) {
                sum += Character.digit(a.charAt(i--), 10);
            }
            if (j >= 0) {
                sum += Character.digit(b.charAt(j--), 10);
            }
            cary = sum > 1 ? 1 : 0;
            stringBuilder.append(sum % 2);
        }
        if (cary != 0) {
            stringBuilder.append(cary);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(0 % 2);
        Solution2 solution = new Solution2();
        //110001
        System.out.println(solution.addBinary("100", "110010"));
    }
}
