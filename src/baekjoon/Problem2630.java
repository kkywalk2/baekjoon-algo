package baekjoon;
import java.util.Scanner;

public class Problem2630 {
    private static int white = 0;
    private static int blue = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] rectangle = new int[length][length];
        Boolean same = true;
        for(int i = 0; i < length * length ; i++) {
            rectangle[i/length][i%length] = sc.nextInt();
        }
        for(int i = 1; i < length * length ; i++) {
            if(rectangle[i/length][i%length] != rectangle[(i-1)/length][(i-1)%length]) {
                same = false;
                break;
            }
        }
        sc.close();
        if(same) {
            if(rectangle[0][0] == 0) {
                white++;
            }else {
                blue++;
            }
        }else
            caculateRectangle(0, 0, length, rectangle);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void caculateRectangle(int x_offset, int y_offset, int length, int[][] rectangle) {
        int n = length;

        if (n / 2 != 0) {
            n = n / 2;
            for (int i = 0; i < (length / n) * (length / n); i++) {
                int x = x_offset + (i / (length / n)) * n;
                int y = y_offset + (i % (length / n)) * n;
                int v = rectangle[x][y];
                for (int j = 0; j < n * n; j++) {
                    if (rectangle[x + j / n][y + j % n] != v) {
                        caculateRectangle(x, y, n, rectangle);
                        break;
                    }
                    if (j == (n * n - 1)) {
                        if (v == 0)
                            white++;
                        else
                            blue++;
                    }
                }
            }
        }
    }
}
