package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
    public void subsetsBT(int[] originalNums, int[] nums, List<List<Integer>> result, int startIdx, int size,
            int targetSize) {
        if (size == targetSize) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = startIdx; i < originalNums.length; i++) {
                nums[size] = originalNums[i];
                subsetsBT(originalNums, nums, result, i + 1, size + 1, targetSize);
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            subsetsBT(nums, new int[i], result, 0, 0, i);
        }
        return result;
    }
}
