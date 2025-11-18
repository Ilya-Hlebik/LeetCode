package freeRun.lc_62_273_Integer_to_English_Words;

public class Solution {
    String[] numbers = new String[]{"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine",
            " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    String[] tens = new String[]{"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    String[] big = new String[]{"", " Thousand", " Million", " Billion"};
    String hundred = " Hundred";

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder builder_response = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            int current = num % 1000;
            if (current == 0){
                num /= 1000;
                continue;
            }
            int begin = current / 100;
            int middle = (current / 10) % 10;
            int last = current % 10;
            int twoLast = current % 100;
            builder_response.insert(0, (begin > 0 ? numbers[begin] + hundred : "") + (middle > 1 ? tens[middle] + numbers[last] : numbers[twoLast]) + big[i]);
            num /= 1000;
        }
        return builder_response.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(1234567891));
    }
}
