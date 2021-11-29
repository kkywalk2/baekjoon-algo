package leetcode;

import java.util.HashMap;

public class SortColors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        hashMap.put(1, 0);
        hashMap.put(2, 0);
        for (int num : nums) {
            hashMap.put(num, hashMap.get(num) + 1);
        }
        int size = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < hashMap.get(i); j++) {
                nums[size++] = i;
            }
        }
    }
}
