package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem1260 {
    static int[][] points;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        points = new int[n + 1][n + 1];

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[x][y] = points[y][x] = 1;
        }

        dfs(v, n);
        System.out.println();
        bfs(v, n);
        sc.close();
    }

    public static void dfs(int start, int size) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visits = new boolean[size + 1];
        visits[start] = true;
        System.out.print(start + " ");
        while(true) {
            boolean find = false;
            for(int i = 1; i < size + 1; i++) {
                if(points[start][i] == 1 && visits[i] == false){
                    stack.push(start);
                    start = i;
                    System.out.print(start + " ");
                    visits[start] = true;
                    find = true;
                    break;
                }
            }

            if(!find){
                if(stack.isEmpty())
                    break;

                start = stack.pop();
            }
        }
    }

    public static void bfs(int start, int size) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visits = new boolean[size + 1];
        queue.offer(start);
        visits[start] = true;
        System.out.print(start + " ");
        while(!queue.isEmpty()) {
            start = queue.poll();
            for(int i = 1; i < size + 1; i++) {
                if(points[start][i] == 1 && visits[i] == false){
                    queue.offer(i);
                    System.out.print(i + " ");
                    visits[i] = true;
                }
            }
        }
    }
}