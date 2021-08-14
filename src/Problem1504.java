import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1504 {

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
        Map<Integer, ArrayList<Point>> points = new HashMap<Integer, ArrayList<Point>>();
        long[] distance_start = new long[pointCount + 1];
        long[] distance_first = new long[pointCount + 1];
        long[] distance_second = new long[pointCount + 1];

        for (int i = 1; i <= lineCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();

            if (points.get(x) == null) {
                points.put(x, new ArrayList<>());
            }
            points.get(x).add(new Point(y, w));

            if (points.get(y) == null) {
                points.put(y, new ArrayList<>());
            }
            points.get(y).add(new Point(x, w));
        }

        int start = 1;
        int first = sc.nextInt();
        int second = sc.nextInt();

        for (int i = 1; i <= pointCount; i++) {
            if (start == i) {
                distance_start[i] = 0;
                continue;
            }
            distance_start[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= pointCount; i++) {
            if (first == i) {
                distance_first[i] = 0;
                continue;
            }
            distance_first[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= pointCount; i++) {
            if (second == i) {
                distance_second[i] = 0;
                continue;
            }
            distance_second[i] = Integer.MAX_VALUE;
        }

        dijkstra(points, distance_start, start, pointCount);
        dijkstra(points, distance_first, first, pointCount);
        dijkstra(points, distance_second, second, pointCount);

        long firstDistance = distance_start[first] + distance_first[second] + distance_second[pointCount];
        long secondDistance = distance_start[second] + distance_second[first] + distance_first[pointCount];
        long result = firstDistance < secondDistance ? firstDistance : secondDistance;

        if (result >= Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(result);

        sc.close();
    }

    public static void dijkstra(Map<Integer, ArrayList<Point>> points, long[] distance, int start, int size) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        boolean[] visits = new boolean[size + 1];
        queue.offer(new Point(start, 0));
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            if (visits[curPoint.y] == true)
                continue;
            visits[curPoint.y] = true;

            if (points.get(curPoint.y) != null) {
                List<Point> list = points.get(curPoint.y);
                for (Point point : list) {
                    if (distance[point.y] > distance[curPoint.y] + point.weight) {
                        distance[point.y] = distance[curPoint.y] + point.weight;
                        queue.offer(new Point(point.y, (int) distance[point.y]));
                    }
                }
            }
        }
    }
}
