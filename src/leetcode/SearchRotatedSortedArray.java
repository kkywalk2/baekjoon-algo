package leetcode;

public class SearchRotatedSortedArray {
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

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int tempResult = binarySearch(nums, 0, left - 1, target);
        if (tempResult != -1) {
            return tempResult;
        }
        return binarySearch(nums, left, nums.length - 1, target);
    }
}
