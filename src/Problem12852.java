import java.util.Scanner;

public class Problem12852 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        String[] processStrings = new String[n+1];

        dp[1] = 0;
        processStrings[1] = "1";

        for (int i = 2; i <= n; i++) {
            int temp = Integer.MAX_VALUE;
            int before = 0;

            if (i % 3 == 0) {
                temp = dp[i / 3];
                before = i / 3;
            }

            if (i % 2 == 0) {
                if (temp > dp[i / 2]) {
                    temp = dp[i / 2];
                    before = i / 2;
                }
            }

            if (temp > dp[i - 1]) {
                before = i - 1;
            }

            dp[i] = dp[before] + 1;
            processStrings[i] = i + " " + processStrings[before];
        }
        System.out.println(dp[n]);
        System.out.println(processStrings[n]);
        sc.close();
    }
}
