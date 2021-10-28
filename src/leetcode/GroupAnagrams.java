package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<String> oriStrs = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> result = new ArrayList<>();

        while (!oriStrs.isEmpty()) {
            String str = oriStrs.remove(0);
            Map<Character, int[]> map = new HashMap<>();
            List<String> anagram = new ArrayList<>();
            anagram.add(str);

            for (int i = 0; i < str.length(); i++) {
                int[] value = map.getOrDefault(str.charAt(i), new int[] { 0, 0 });
                value[0] += 1;
                map.put(str.charAt(i), value);
            }

            for (String comp : oriStrs) {
                if (comp.length() == str.length()) {
                    for (int i = 0; i < comp.length(); i++) {
                        int[] value = map.get(comp.charAt(i));
                        if (value == null) {
                            break;
                        } else {
                            value[1] += 1;
                        }
                    }

                    boolean isAnagram = true;
                    for (char c : map.keySet()) {
                        int[] value = map.get(c);
                        if (value[0] != value[1]) {
                            isAnagram = false;
                        }
                        value[1] = 0;
                    }

                    if (isAnagram) {
                        anagram.add(comp);
                    }
                }
            }

            result.add(anagram);
            oriStrs.removeAll(anagram);
        }

        return result;
    }
}
