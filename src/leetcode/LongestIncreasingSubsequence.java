package leetcode;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (size == 0 || lis[size - 1] < nums[i]) {
                lis[size++] = nums[i];
            } else {
                binarySearch(lis, nums[i], size);
            }
        }
        return size;
    }

    public void binarySearch(int[] lis, int num, int size) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] == num) {
                return;
            }

            if (lis[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        lis[right] = num;
    }

    public static void main(String[] args) throws Exception {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        longestIncreasingSubsequence.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12});
        //longestIncreasingSubsequence.lengthOfLIS(new int[] {3,2,5,2,3,1,4});
    }
}
