package baekjoon;

import java.util.Scanner;

public class Problem2579 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stair = new int[n];
        int[][] dp = new int[2][n];

        for (int i = 0; i < n; i++) {
            stair[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(stair[0]);
        } else {
            dp[0][0] = stair[0];
            dp[0][1] = stair[1] + stair[0];
            dp[1][1] = stair[1];

            for (int i = 2; i < n; i++) {
                dp[0][i] = dp[1][i - 1] + stair[i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[1][i - 2]) + stair[i];
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
        sc.close();
    }
}
