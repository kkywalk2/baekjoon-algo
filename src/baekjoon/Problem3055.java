package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem3055 {
    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        String[] matrix = new String[r];
        int[][] water = new int[r][c];
        int[][] hedgehog = new int[r][c];
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            matrix[i] = sc.nextLine();
        }
        bfsWater(matrix, water);
        int distance = bfsHedgehog(matrix, hedgehog, water);
        if(distance != -1) {
            System.out.println(distance);
        } else {
            System.out.println("KAKTUS");
        }
        sc.close();
    }

    public static void bfsWater(String[] matrix, int[][] water) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visit = new boolean[water.length][water[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length(); j++) {
                water[i][j] = -1;
                if(matrix[i].charAt(j) == '*') {
                    queue.offer(i);
                    queue.offer(j);
                    water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nX = x + direction[i][0];
                int nY = y + direction[i][1];
                if(nX < 0 || nY < 0 || nX >= water.length || nY >= water[0].length) continue;
                if(visit[nX][nY]) continue;
                if(matrix[nX].charAt(nY) != '.') continue;
                visit[nX][nY] = true;
                water[nX][nY] = water[x][y] + 1;
                queue.add(nX);
                queue.add(nY);
            }
        }
    }

    public static int bfsHedgehog(String[] matrix, int[][] hedgehog, int[][] water) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visit = new boolean[water.length][water[0].length];
        int dX = 0;
        int dY = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length(); j++) {
                hedgehog[i][j] = -1;
                if(matrix[i].charAt(j) == 'S') {
                    queue.offer(i);
                    queue.offer(j);
                    hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }

                if(matrix[i].charAt(j) == 'D') {
                    dX = i;
                    dY = j;
                }
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nX = x + direction[i][0];
                int nY = y + direction[i][1];
                if(nX < 0 || nY < 0 || nX >= water.length || nY >= water[0].length) continue;
                if(visit[nX][nY]) continue;
                if(matrix[nX].charAt(nY) != '.' && matrix[nX].charAt(nY) != 'D') continue;
                if(water[nX][nY] != -1 && water[nX][nY] <= hedgehog[x][y] + 1) continue;
                visit[nX][nY] = true;
                hedgehog[nX][nY] = hedgehog[x][y] + 1;
                queue.offer(nX);
                queue.offer(nY);
            }
        }

        return hedgehog[dX][dY];
    }
}
