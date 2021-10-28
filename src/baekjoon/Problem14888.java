package baekjoon;
import java.util.Scanner;

public class Problem14888 {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] nums = new int[m];
        int[] operators = new int[4];

        for(int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        caculate(nums, operators, 0, nums[0]);
        System.out.println(max);
        System.out.println(min);
        sc.close();
    }

    public static void caculate(int[] nums, int[] operators, int k, int value) {
        if(k == nums.length - 1) {
            max = Math.max(value, max);
            min = Math.min(value, min);
        } else {
            for(int i = 0; i < 4; i++) {
                if(operators[i] >= 1) {
                    operators[i]--;
                    int newValue = value;
                    if(i == 0) newValue = newValue + nums[k + 1];
                    if(i == 1) newValue = newValue - nums[k + 1];
                    if(i == 2) newValue = newValue * nums[k + 1];
                    if(i == 3) newValue = newValue / nums[k + 1];
                    caculate(nums, operators, k + 1, newValue);
                    operators[i]++;
                }
            }
        }
    }
}
