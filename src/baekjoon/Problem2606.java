package baekjoon;
import java.util.Scanner;
import java.util.Stack;

public class Problem2606 {
    static int[][] points;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = 1;
        points = new int[n + 1][n + 1];

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[x][y] = points[y][x] = 1;
        }

        dfs(v, n);
        System.out.println(count);
        sc.close();
    }

    public static void dfs(int start, int size) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visits = new boolean[size + 1];
        visits[start] = true;
        while(true) {
            boolean find = false;
            for(int i = 1; i < size + 1; i++) {
                if(points[start][i] == 1 && visits[i] == false){
                    stack.push(start);
                    start = i;
                    visits[start] = true;
                    find = true;
                    count++;
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
}