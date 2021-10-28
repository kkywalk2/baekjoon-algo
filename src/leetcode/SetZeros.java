package leetcode;

class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int x = matrix.length;
        int y = matrix[0].length;

        for (int i = 0; i < x; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < y; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < y; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < x; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
