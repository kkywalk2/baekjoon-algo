package leetcode;

public class Search2DMatrix {
    public int binarySearch(int[] nums, int left, int right, int target) {
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                result = mid;
                break;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int result = binarySearch(matrix[i], 0, matrix[i].length - 1, target);
            if (result != -1)
                return true;
        }
        return false;
    }
}
