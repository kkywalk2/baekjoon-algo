import java.util.Scanner;

public class Problem2293 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n + 1][k + 1];
        int[] coins = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
        sc.close();
    }
}
