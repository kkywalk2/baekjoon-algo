import java.util.Scanner;

public class Problem1752 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int pointCount = sc.nextInt();
        int lineCount = sc.nextInt();
        int start = sc.nextInt();
        int[][] points = new int[pointCount + 1][pointCount + 1];
        int[] distance = new int[pointCount + 1];

        for(int i = 1; i <= pointCount; i++){
            for(int j = 1; j <= pointCount; j++){
                points[i][j] = Integer.MAX_VALUE - 10000;
            }
        }

        for(int i = 1; i <= lineCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            points[x][y] = points[y][x] = w;
        }

        for(int i = 1; i <= pointCount; i++){
            if(start == i){
                distance[i] = 0;
                continue;
            }
            distance[i] = points[start][i];
        }

        dijkstra(points, distance, start, pointCount);

        for(int i = 1; i <= pointCount; i++){
            if(distance[i] > 1000)
                System.out.println("INF");
            System.out.println(distance[i]);
        }
        sc.close();
    }

    public static void dijkstra(int[][] points, int[] distance, int start, int size) {
        boolean[] visits = new boolean[size + 1];
        int count = 0;
        while(true) {
            int min = Integer.MAX_VALUE;
            int next = 0;
            for(int i = 1; i <= size; i++) {
                if(visits[i] == false){
                    if(min > distance[i]) {
                        min = distance[i];
                        next = i;
                    }
                }
            }

            visits[next] = true;
            count++;
            for(int i = 1; i <= size; i++){
                distance[i] = Math.min(distance[i], distance[next] + points[next][i]);
            }

            if(count == size)
                break;
        }
    }
}
