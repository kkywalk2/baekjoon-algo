package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1697 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        bfs(n, k);
        sc.close();
    }

    public static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[100001];
        dist[n] = 1;
        queue.offer(n);

        while(!queue.isEmpty()) {
            int currentPosition = queue.poll();

            int[] nextPosition = new int[3];
            nextPosition[0] = currentPosition + 1;
            nextPosition[1] = currentPosition - 1;
            nextPosition[2] = currentPosition * 2;

            for(int nP : nextPosition) {
                if(nP >= 0 && nP <= 100000) {
                    if(dist[nP] == 0) {
                        dist[nP] = dist[currentPosition] + 1;
                        queue.offer(nP);
                    }
                }
            }
        }

        System.out.println(dist[k] - 1);
    }
}
