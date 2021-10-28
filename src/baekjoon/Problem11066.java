package baekjoon;
import java.util.Scanner;

public class Problem11066 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();

        for (int testNum = 0; testNum < testCount; testNum++) {

            int chapterCount = sc.nextInt();

            int[] chapterSize = new int[chapterCount + 1];
            int[] sum = new int[chapterCount + 1];
            int[][] dp = new int[chapterCount + 1][chapterCount + 1];

            for (int i = 1; i <= chapterCount; i++) {
                chapterSize[i] = sc.nextInt();
                sum[i] = sum[i - 1] + chapterSize[i];
            }

            for (int i = 2; i <= chapterCount; i++) {
                for (int j = i - 1; j > 0; j--) {
                    dp[j][i] = Integer.MAX_VALUE;
                    for (int s = j; s < i; s++)
                        dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);

                    dp[j][i] += sum[i] - sum[j - 1];
                }
            }

            System.out.println(dp[1][chapterCount]);
        }

        sc.close();
    }

}
