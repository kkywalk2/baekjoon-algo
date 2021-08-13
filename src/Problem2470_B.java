import java.util.Arrays;
import java.util.Scanner;

public class Problem2470_B {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] liquid = new int[count];

        for (int i = 0; i < count; i++) {
            liquid[i] = sc.nextInt();
        }

        Arrays.sort(liquid);

        twoPointer(liquid);
        sc.close();
    }

    public static void twoPointer(int[] liquid) {
        int left = 0;
        int right = liquid.length - 1;

        while (true) {
            if ((Math.abs((liquid[left] + liquid[right])) > Math.abs((liquid[left + 1] + liquid[right])))
                    && ((left + 1) < right)) {
                left++;
            } else if ((Math.abs((liquid[left] + liquid[right])) > Math.abs((liquid[left] + liquid[right - 1])))
                    && (left < (right - 1))) {
                right--;
            } else {
                System.out.println(liquid[left] + " " + liquid[right]);
                break;
            }
        }
    }
}
