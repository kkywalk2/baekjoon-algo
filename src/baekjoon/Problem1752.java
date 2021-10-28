package baekjoon;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1752 {

    public static class Point implements Comparable<Point> {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return getDistance(new Point(1, 1), this) >= getDistance(new Point(1, 1), o) ? 1 : - 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int pointCount = sc.nextInt();
        List<Point> points = new ArrayList<Point>();

        for (int i = 1; i <= pointCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        List<List<Point>> result = doCombination(points, 3);
        caculateFootage(points, result);

        sc.close();
    }

    public static void caculateFootage(List<Point> points, List<List<Point>> combination) {
        int count = 0;
        for (List<Point> list : combination) {
            Point p1 = list.get(0);
            Point p2 = list.get(1);
            Point p3 = list.get(2);

            if (isSameLine(p1, p2, p3)) {
                int temp = 0;
                PriorityQueue<Point> queue = new PriorityQueue<>();

                for (Point point : points) {
                    if (isSameLine(p1, p2, point)){
                        queue.offer(point);
                        temp++;
                    }
                }

                Point firstPoint = queue.poll();
                Point secondPoint = queue.poll();
                double distance = getDistance(firstPoint, secondPoint);
                boolean isSameDistance = true;
                while(!queue.isEmpty()) {
                    firstPoint = secondPoint;
                    secondPoint = queue.poll();

                    if(getDistance(firstPoint, secondPoint) != distance){
                        isSameDistance = false;
                    }
                }

                if (count < temp && isSameDistance)
                    count = temp;
            }
        }

        System.out.println(count);
    }

    public static List<List<Point>> doCombination(List<Point> points, int target) {
        List<List<Point>> result = new ArrayList<>();
        if (target == 1) {
            for (Point p : points) {
                List<Point> list = new ArrayList<>();
                list.add(new Point(p.x, p.y));
                result.add(list);
            }
        } else {
            for (int i = 0; i < points.size(); i++) {
                List<Point> rest = points.subList(i + 1, points.size());
                List<List<Point>> temp = doCombination(rest, target - 1);
                for (List<Point> list : temp) {
                    Point p = points.get(i);
                    list.add(new Point(p.x, p.y));
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static double angle(Point a, Point b, Point c) {
        double aa, bb, cc;
        double ang, temp;

        aa = Math.sqrt(Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2));
        bb = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        cc = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2));

        temp = (Math.pow(bb, 2) + Math.pow(cc, 2) - Math.pow(aa, 2)) / (2 * bb * cc);
        ang = Math.acos(temp);
        ang = ang * (180 / Math.PI);

        return ang;
    }

    public static boolean isSameLine(Point a, Point b, Point c) {
        if ((a.x == b.x && b.x == c.x) || (a.y == b.y && b.y == c.y)) {
                return true;
        }

        double x1 = a.x - b.x;
        double y1 = a.y - b.y;

        try {
            double angle = y1 / x1;
            double zulpyen = a.y - a.x * angle;
            if (c.x * angle + zulpyen == c.y) {
                return true;
            } else
                return false;
        } catch (Exception ex) {
            return false;
        }
    }

    static double getDistance(Point a, Point b) {
        double d;
        double xd, yd;
        yd = Math.pow((a.y - b.y), 2);
        xd = Math.pow((a.x - b.x), 2);
        d = Math.sqrt(yd + xd);
        return d;
    }
}
