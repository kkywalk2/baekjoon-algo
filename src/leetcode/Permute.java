package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permute {
    public void permuteBT(boolean[] used, int[] originalNums, int[] nums, List<List<Integer>> result, int size) {
        if (size == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = 0; i < originalNums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    nums[size] = originalNums[i];
                    permuteBT(used, originalNums, nums, result, size + 1);
                    used[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        permuteBT(used, nums, new int[nums.length], result, 0);
        return result;
    }
}
