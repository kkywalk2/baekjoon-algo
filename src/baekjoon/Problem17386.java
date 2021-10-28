package baekjoon;
import java.util.Scanner;

public class Problem17386 {
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

        Point[] points = new Point[4];
        for (int i = 0; i < 4; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        sc.close();

        if (ccw(points[0], points[1], points[2]) * ccw(points[0], points[1], points[3]) < 0
                && ccw(points[2], points[3], points[0]) * ccw(points[2], points[3], points[1]) < 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static double ccw(Point p1, Point p2, Point p3) {
        return ((p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.x * p3.y + p2.x * p1.y + p3.x * p2.y));
    }
}
