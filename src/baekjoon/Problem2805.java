package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextInt();
        int[] treeLength = new int[N];
        for(int i = 0; i < N; i++) {
            treeLength[i] = sc.nextInt();
        }
        Arrays.sort(treeLength);
        System.out.println(search(treeLength, M));
        sc.close();
    }

    public static long search(int[] treeLength, long M) {
        int length = treeLength.length;
        long left = 0;
        long right = treeLength[length - 1];
        long ans = 0;

        while(left <= right) {
            long mid = (left + right) / 2;

            long tempSum = 0;
            for(int i = 0; i < length; i++) {
                long value = treeLength[i] - mid;
                tempSum += value > 0 ? value : 0;
            }

            if(tempSum >= M) {
                ans = mid;
                left = mid + 1;
            } else { 
                right = mid - 1;
            }
        }

        return ans;
    }
}
