package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (int key : hashMap.keySet()) {
            if (bucket[hashMap.get(key)] == null) {
                bucket[hashMap.get(key)] = new ArrayList<>();
            }
            bucket[hashMap.get(key)].add(key);
        }

        int bucketIdx = nums.length;
        int resultIdx = 0;
        while (k > resultIdx) {
            while (bucket[bucketIdx] == null && bucketIdx > 0)
                bucketIdx--;
            if (bucket[bucketIdx] == null)
                break;
            for (int key : bucket[bucketIdx]) {
                result[resultIdx++] = key;
            }
            bucketIdx--;
        }
        return result;
    }
}
