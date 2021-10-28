package baekjoon;
import java.util.Scanner;

public class Problem1780 {

    private static int ngOne = 0;
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] rectangle = new int[length][length];
        for (int i = 0; i < length * length; i++) {
            rectangle[i / length][i % length] = sc.nextInt();
        }
        sc.close();
        divAndConq(0, 0, length, rectangle);
        System.out.println(ngOne);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void divAndConq(int x, int y, int n, int[][] rectangle) throws Exception {
        int v = rectangle[x][y];
        if (caculate(v, x, y, n, rectangle)) {
            switch (v) {
                case -1:
                    ngOne++;
                    return;
                case 0:
                    zero++;
                    return;
                case 1:
                    one++;
                    return;
                default:
                    throw new Exception("Invalid Input!");
            }
        }

        int div = n / 3;
        if (div == 0)
            return;

        divAndConq(x, y, div, rectangle);
        divAndConq(x, y + div, div, rectangle);
        divAndConq(x, y + div * 2, div, rectangle);
        divAndConq(x + div, y, div, rectangle);
        divAndConq(x + div, y + div, div, rectangle);
        divAndConq(x + div, y + div * 2, div, rectangle);
        divAndConq(x + div * 2, y, div, rectangle);
        divAndConq(x + div * 2, y + div, div, rectangle);
        divAndConq(x + div * 2, y + div * 2, div, rectangle);
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
