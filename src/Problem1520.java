import java.util.Scanner;

public class Problem1520 {

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] matrix = new int[x + 1][y + 1];
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++)
            for (int j = 1; j <= y; j++) {
                matrix[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        System.out.println(dfs(dp, matrix, 1, 1));
        sc.close();
    }

    public static int dfs(int[][] dp, int[][] matrix, int x, int y) {
        if (dp[0].length - 1 == y && dp.length - 1 == x)
            return 1;

        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            if (x + 1 <= dp.length - 1 && matrix[x][y] > matrix[x + 1][y]) {
                dp[x][y] += dfs(dp, matrix, x + 1, y);
            }

            if (y + 1 <= dp[0].length - 1 && matrix[x][y] > matrix[x][y + 1]) {
                dp[x][y] += dfs(dp, matrix, x, y + 1);
            }

            if (x - 1 > 0 && matrix[x][y] > matrix[x - 1][y]) {
                dp[x][y] += dfs(dp, matrix, x - 1, y);
            }

            if (y - 1 > 0 && matrix[x][y] > matrix[x][y - 1]) {
                dp[x][y] += dfs(dp, matrix, x, y - 1);
            }
        }
        return dp[x][y];
    }
}
