package leetcode;

public class NumIslands {
    int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void dfs(boolean[][] visit, char[][] grid, int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];
            if (nX < 0 || nY < 0 || nX >= grid.length || nY >= grid[0].length)
                continue;
            if (visit[nX][nY])
                continue;
            if (grid[nX][nY] == '0')
                continue;
            dfs(visit, grid, nX, nY);
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(visit, grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
}
