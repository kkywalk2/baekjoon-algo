package baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1916 {

    public static class Point implements Comparable<Point> {
        public int y;
        public long weight;

        @Override
        public int compareTo(Point o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cityNum = sc.nextInt();
        int busNum = sc.nextInt();
        ArrayList<ArrayList<Point>> graph = new ArrayList<>();

        for (int i = 0; i <= cityNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < busNum; i++) {
            Point point = new Point();
            int start = sc.nextInt();
            point.y = sc.nextInt();
            point.weight = sc.nextInt();
            graph.get(start).add(point);
        }
        int startPoint = sc.nextInt();
        int endPoint = sc.nextInt();

        dijkstra(startPoint, endPoint, graph, cityNum);
        sc.close();
    }

    public static void dijkstra(int startPoint, int endPoint, ArrayList<ArrayList<Point>> graph, int cityNum) {
        long[] dist = new long[cityNum + 1];
        PriorityQueue<Point> queue = new PriorityQueue<>();

        for(int i  = 1; i <= cityNum; i++) {
            dist[i] = Long.MAX_VALUE;
            if(i == startPoint) {
                dist[i] = 0;
                Point point = new Point();
                point.y = i;
                point.weight = 0;
                queue.offer(point);
            }
        }

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            if(dist[point.y] >= point.weight) {
                for(Point to : graph.get(point.y)) {
                    long newWeigt = dist[point.y] + to.weight;
                    if(newWeigt < dist[to.y]) {
                        dist[to.y] = newWeigt;
                        Point nextPoint = new Point();
                        nextPoint.y = to.y;
                        nextPoint.weight = newWeigt;
                        queue.offer(nextPoint);
                    }
                }
            }
        }

        System.out.println(dist[endPoint]);
    }
}
