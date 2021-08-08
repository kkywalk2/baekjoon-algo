import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Problem9372 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test = 0; test < T; test++) {
            int nationCount = sc.nextInt();
            int planeCount = sc.nextInt();  
            int[][] graph = new int[nationCount+1][nationCount+1];

            for(int i = 1; i <= planeCount; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x][y] = 1;
                graph[y][x] = 1;
            }
            System.out.println(bfs(graph, 1, nationCount));
        }
        sc.close();
    }

    public static int bfs(int[][] graph, int start, int size) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visits = new boolean[size + 1];
        int result = 0;
        queue.offer(start);
        visits[start] = true;
        while(!queue.isEmpty()) {
            start = queue.poll();
            for(int i = 1; i < size + 1; i++) {
                if(graph[start][i] == 1 && visits[i] == false){
                    queue.offer(i);
                    visits[i] = true;
                    result++;
                }
            }
        }
        return result;
    }
 
}
