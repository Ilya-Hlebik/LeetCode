package TopInterview150.Chapter_1_Array_String.lc_23_68_Text_Justification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        Queue<String> tempWords = new LinkedList<>();
        int currentSize = 0;
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (currentSize + word.length() + tempWords.size() > maxWidth) {
                StringBuilder line = new StringBuilder();
                int countOfSpaces = tempWords.size() - 1;
                int totalSpaceAmount = maxWidth - currentSize;
                while (!tempWords.isEmpty()) {
                    double step = Math.ceil((double) totalSpaceAmount / countOfSpaces);
                    line.append(tempWords.poll());
                    if (!tempWords.isEmpty()) {
                        for (int j = 0; j < step; j++) {
                            line.append(" ");
                            totalSpaceAmount--;
                        }
                        countOfSpaces--;
                    }
                }
                while (line.length() != maxWidth) {
                    line.append(" ");
                }
                result.add(line.toString());
                currentSize = 0;
            }
            currentSize += word.length();
            tempWords.add(word);
        }
        StringBuilder line = new StringBuilder();
        while (!tempWords.isEmpty()) {
            line.append(tempWords.poll());
            if (!tempWords.isEmpty()) {
                line.append(" ");
            }
        }
        while (line.length()!=maxWidth){
            line.append(" ");
        }
        result.add(line.toString());
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
    }
}
