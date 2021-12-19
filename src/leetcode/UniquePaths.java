package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class UniquePaths {
    int[][] robotDir = new int[][] { { 1, 0 }, { 0, 1 } };
    int[][] backDir = new int[][] { { -1, 0 }, { 0, -1 } };

    public void bfs(int[][] graph, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();

        if (graph.length > 1) {
            queue.offer(x + 1);
            queue.offer(y);
        }

        if (graph[0].length > 1) {
            queue.offer(x);
            queue.offer(y + 1);
        }

        graph[0][0] = 1;

        while (!queue.isEmpty()) {
            Queue<Integer> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                x = queue.poll();
                y = queue.poll();

                if (graph[x][y] == 0) {
                    int pathCount = 0;
                    for (int i = 0; i < 2; i++) {
                        int nX = x + backDir[i][0];
                        int nY = y + backDir[i][1];
                        if (nX < 0 || nY < 0 || nX >= graph.length || nY >= graph[0].length)
                            continue;
                        pathCount += graph[nX][nY];
                    }
                    graph[x][y] += pathCount;

                    for (int i = 0; i < 2; i++) {
                        int nX = x + robotDir[i][0];
                        int nY = y + robotDir[i][1];
                        if (nX < 0 || nY < 0 || nX >= graph.length || nY >= graph[0].length)
                            continue;
                        tempQueue.offer(nX);
                        tempQueue.offer(nY);
                    }
                }
            }
            queue = tempQueue;
        }
    }

    public int uniquePaths(int m, int n) {
        int[][] graph = new int[m][n];
        bfs(graph, 0, 0);
        return graph[m - 1][n - 1];
    }
}
