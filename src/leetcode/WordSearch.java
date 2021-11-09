package leetcode;

public class WordSearch {
    int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    boolean isExist = false;

    public void existBT(char[][] board, int x, int y, String word, int idx, boolean[][] visit) {
        if (word.length() == idx)
            isExist = true;
        else {
            for (int i = 0; i < 4; i++) {
                int nX = x + dir[i][0];
                int nY = y + dir[i][1];
                if (nX < 0 || nY < 0 || nX >= board.length || nY >= board[0].length)
                    continue;
                if (visit[nX][nY])
                    continue;
                if (board[nX][nY] != word.charAt(idx))
                    continue;
                visit[x][y] = true;
                existBT(board, nX, nY, word, idx + 1, visit);
                visit[x][y] = false;
            }
        }
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visit = new boolean[board.length][board[0].length];
                    existBT(board, i, j, word, 1, visit);
                }
            }
        }
        return isExist;
    }
}
