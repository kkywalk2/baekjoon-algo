package baekjoon;
import java.util.Scanner;

public class Problem11049 {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        arr = new int[n + 1][2];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = arr[i][0] * arr[i][1] * arr[i + 1][1];
        }

        for (int m = 2; m < n; m++) {
            for (int i = 1; i <= n - m; i++) {
                int j = i + m;
                for (int k = i; k < j; k++) {
                    int res = dp[i][k] + dp[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1];
                    if (dp[i][j] == 0 || dp[i][j] > res)
                        dp[i][j] = res;
                }
            }
        }

        System.out.println(dp[1][n]);
        sc.close();
    }
}
