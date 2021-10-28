package baekjoon;
import java.util.Scanner;

public class Problem1992 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] rectangle = new int[length][length];
        for (int i = 0; i < length; i++) {
            String[] token = sc.next().split("");
            for (int j = 0; j < length; j++)
                rectangle[i][j] = Integer.parseInt(token[j]);
        }
        sc.close();
        divAndConq(0, 0, length, rectangle);
    }

    public static void divAndConq(int x, int y, int n, int[][] rectangle) {
        int v = rectangle[x][y];
        if (caculate(v, x, y, n, rectangle)) {
            switch (v) {
                case 0:
                    System.out.print("0");
                    return;
                case 1:
                    System.out.print("1");
                    return;
                default:
                    throw new RuntimeException("Invalid Input!");
            }
        }

        int div = n / 2;
        if (div == 0)
            return;

        System.out.print("(");
        divAndConq(x, y, div, rectangle);
        divAndConq(x, y + div, div, rectangle);
        divAndConq(x + div, y, div, rectangle);
        divAndConq(x + div, y + div, div, rectangle);
        System.out.print(")");
    }

    public static Boolean caculate(int v, int x, int y, int n, int[][] rectangle) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v != rectangle[x + i][y + j])
                    return false;
            }
        }
        return true;
    }
}
