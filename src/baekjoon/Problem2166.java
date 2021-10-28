package baekjoon;
import java.util.Scanner;

public class Problem2166 {

    public static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        sc.close();

        double area = 0;
        for (int i = 0; i <= n - 3; i++) {
            area += caculateArea(points[0], points[i + 1], points[i + 2]);
        }
        System.out.printf("%.1f\n", Math.abs(area));
    }

    public static double caculateArea(Point p1, Point p2, Point p3) {
        return ((p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.x * p3.y + p2.x * p1.y + p3.x * p2.y))/2;
    }
}