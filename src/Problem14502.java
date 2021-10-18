import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem14502 {
    static int minCount = Integer.MAX_VALUE;
    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int[][] blank = new int[n * m + 1][2];
        int blankCount = 0;
        ArrayList<int[]> virus = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();

                if (matrix[i][j] == 2) {
                    virus.add(new int[] { i, j });
                }

                if (matrix[i][j] == 0) {
                    blankCount++;
                    blank[blankCount][0] = i;
                    blank[blankCount][1] = j;
                }
            }
        searchAll(matrix, blank, blankCount, 0, 1, virus);
        System.out.println(blankCount - minCount - 3);
        sc.close();
    }

    public static void searchAll(int[][] matrix, int[][] blank, int blankCount, int selectCount, int idx,
            ArrayList<int[]> virus) {
        if (selectCount == 3) {
            bfs(matrix, virus);
            return;
        }
        if(idx > blankCount) return;

        matrix[blank[idx][0]][blank[idx][1]] = 1;
        searchAll(matrix, blank, blankCount, selectCount + 1, idx + 1, virus);

        matrix[blank[idx][0]][blank[idx][1]] = 0;
        searchAll(matrix, blank, blankCount, selectCount, idx + 1, virus);
    }

    public static void bfs(int[][] matrix, ArrayList<int[]> virus) {
        Queue<int[]> queue = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visit = new boolean[n][m];
        int count = 0;
        for (int[] v : virus) {
            queue.add(new int[] { v[0], v[1] });
            visit[v[0]][v[1]] = true;
            //count++;
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = point[0] + direction[i][0];
                int nY = point[1] + direction[i][1];
                if (nX >= 0 && nX < n && nY >= 0 && nY < m && matrix[nX][nY] == 0 && visit[nX][nY] == false) {
                    count++;
                    visit[nX][nY] = true;
                    queue.add(new int[] { nX, nY });
                }
            }
        }

        minCount = Math.min(count, minCount);
    }
}
