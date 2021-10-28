package leetcode;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num <= i) {
                i = num;
            } else if(num <= j) {
                j = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
