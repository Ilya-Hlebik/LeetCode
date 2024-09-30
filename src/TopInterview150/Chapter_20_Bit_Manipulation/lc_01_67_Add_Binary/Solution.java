package TopInterview150.Chapter_20_Bit_Manipulation.lc_01_67_Add_Binary;

public class Solution {
    public String addBinary(String a, String b) {
        int left = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i < 0) {
                if (left != 0 && b.charAt(j) != '0') {
                    stringBuilder.insert(0, "0");
                } else if (b.charAt(j) != '0') {
                    stringBuilder.insert(0, "1");
                } else if (left!=0){
                    stringBuilder.insert(0, "1");
                    left = 0;
                }
                else {
                    stringBuilder.insert(0, "0");
                }
            } else if (j < 0) {
                if (left != 0 && a.charAt(i) != '0') {
                    stringBuilder.insert(0, "0");
                } else if (a.charAt(i) != '0') {
                    stringBuilder.insert(0, "1");
                } else if (left!=0){
                    stringBuilder.insert(0, "1");
                    left = 0;
                }
                else {
                    stringBuilder.insert(0, "0");
                }
            } else {
                if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                    if (left != 0) {
                        stringBuilder.insert(0, "1");
                    } else {
                        stringBuilder.insert(0, "0");
                        left = 1;
                    }
                }
                else if  (a.charAt(i) == '1'|| b.charAt(j) == '1'){
                    if (left != 0) {
                        stringBuilder.insert(0, "0");
                    }
                    else {
                        stringBuilder.insert(0, "1");
                    }
                }
                else {
                    if (left != 0) {
                        stringBuilder.insert(0, "1");
                        left = 0;
                    }
                    else {
                        stringBuilder.insert(0, "0");
                    }
                }
            }
        }
        if (left!=0){
            stringBuilder.insert(0, "1");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //110001
        System.out.println(solution.addBinary("100", "110010"));
    }
}
