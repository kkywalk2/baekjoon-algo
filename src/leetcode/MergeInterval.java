package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else if (result.get(result.size() - 1)[1] < interval[1]) {
                result.get(result.size() - 1)[1] = interval[1];
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
