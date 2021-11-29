package leetcode;

public class FindKthLargest {
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1, j = right;

        while (i <= j) {
            while (i <= j && pivot < nums[i])
                i++;
            while (i <= j && pivot > nums[j])
                j--;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        swap(nums, left, j);

        return j;
    }

    public void quickSelect(int[] nums, int left, int right, int k) {
        int idx = partition(nums, left, right);
        if (k - 1 == idx)
            return;
        if (k - 1 < idx)
            quickSelect(nums, left, idx - 1, k);
        if (k - 1 > idx)
            quickSelect(nums, idx + 1, right, k);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }
}
