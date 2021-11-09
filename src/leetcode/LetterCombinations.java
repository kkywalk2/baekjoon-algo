package leetcode;

import java.util.ArrayList;
import java.util.List;

class LetterCombinations {
    char[][] prefix = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public void backTracking(char[][] prefix, String digits, String combination, List<String> result) {
        if (combination.length() == digits.length()) {
            result.add(combination);
        } else {
            for (int j = 0; j < prefix[digits.charAt(combination.length()) - '2'].length; j++) {
                char c = prefix[digits.charAt(combination.length()) - '2'][j];
                backTracking(prefix, digits, combination + c, result);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
        backTracking(prefix, digits, "", result);
        return result;
    }
}