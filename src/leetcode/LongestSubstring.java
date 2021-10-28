package leetcode;

import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()) {
            char c = s.charAt(j);

            if (map.get(c) == null) {
                map.put(c, j);
                j++;
                longest = Math.max(longest, j - i);
            } else {
                map.remove(s.charAt(i));
                i++;
            }
        }
        return longest;
    }
}
