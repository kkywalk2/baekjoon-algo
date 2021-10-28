package baekjoon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2667 {

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int unionNum = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j) - 0x30;
            }
        }
        searchUnion(matrix);
        sc.close();
    }

    public static void searchUnion(int[][] matrix) {
        int length = matrix.length;
        boolean[][] visit = new boolean[length][length];
        ArrayList<Integer> unionList = new ArrayList<>();
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (visit[i][j] == false && matrix[i][j] == 1) {
                    unionNum = 0;
                    dfs(i, j, matrix, visit);
                    unionList.add(unionNum);
                }
            }

        System.out.println(unionList.size());
        
        Collections.sort(unionList);

        for (int num : unionList)
            System.out.println(num);
    }

    public static void dfs(int x, int y, int[][] matrix, boolean[][] visit) {
        visit[x][y] = true;
        unionNum++;
        for (int i = 0; i < 4; i++) {
            int nX = x + direction[i][0];
            int nY = y + direction[i][1];
            if (nX >= 0 && nX < matrix.length && nY >= 0 && nY < matrix.length && visit[nX][nY] == false
                    && matrix[nX][nY] == 1) {
                dfs(nX, nY, matrix, visit);
            }
        }
    }
}
