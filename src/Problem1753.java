import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1753 {

    public static class Point implements Comparable<Point> {
        int y;
        int weight;

        public Point(int y, int weight) {
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int pointCount = sc.nextInt();
        int lineCount = sc.nextInt();
        int start = sc.nextInt();
        Map<Integer, ArrayList<Point>> points = new HashMap<Integer, ArrayList<Point>>();
        long[] distance = new long[pointCount + 1];

        for (int i = 1; i <= lineCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            if (points.get(x) == null) {
                points.put(x, new ArrayList<>());
            }
            points.get(x).add(new Point(y, w));
        }

        for (int i = 1; i <= pointCount; i++) {
            if (start == i) {
                distance[i] = 0;
                continue;
            }
            distance[i] = Integer.MAX_VALUE;
        }

        dijkstra(points, distance, start, pointCount);

        for (int i = 1; i <= pointCount; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
        sc.close();
    }

    public static void dijkstra(Map<Integer, ArrayList<Point>> points, long[] distance, int start, int size) {
        boolean[] visits = new boolean[size + 1];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        while (!queue.isEmpty()) {
            Point curNode = queue.poll();
            int cur = curNode.y;

            if (visits[cur] == true) continue;
            visits[cur] = true;

            ArrayList<Point> list = points.get(cur);
            if (list == null)
                continue;

            for (Point p : list) {
                if(distance[p.y] > distance[cur] + p.weight) {
                    distance[p.y] = distance[cur] + p.weight;
                    queue.add(new Point(p.y, (int)distance[p.y]));
                }
            }
        }
    }
}
