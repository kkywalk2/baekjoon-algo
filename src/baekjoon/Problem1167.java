package baekjoon;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Problem1167 {

    public static class Point {
        int y;
        int weight;

        public Point(int y, int weight) {
            this.y = y;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertextCount = sc.nextInt();

        ArrayList<ArrayList<Point>> tree = new ArrayList<>();
        for (int i = 0; i <= vertextCount; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < vertextCount; i++) {
            int vertextNum = sc.nextInt();
            while (true) {
                int connectedNum = sc.nextInt();
                if (connectedNum == -1)
                    break;
                int weight = sc.nextInt();
                tree.get(vertextNum).add(new Point(connectedNum, weight));
            }
        }

        Point tempPoint = dfs(1, vertextCount, tree);
        Point maxPoint = dfs(tempPoint.y, vertextCount, tree);

        System.out.println(maxPoint.weight);
        sc.close();
    }

    public static Point dfs(int start, int size, ArrayList<ArrayList<Point>> tree) {
        Stack<Point> stack = new Stack<>();
        boolean[] visits = new boolean[size + 1];
        visits[start] = true;
        int tempDistance = 0;
        Point distancePoint = new Point(0, 0);
        while (true) {
            boolean find = false;
            ArrayList<Point> list = tree.get(start);
            for (Point point : list) {
                if (visits[point.y] == false) {
                    stack.push(new Point(start,point.weight));
                    tempDistance += point.weight;
                    start = point.y;
                    visits[start] = true;
                    find = true;
                    if(distancePoint.weight < tempDistance) {
                        distancePoint.y = point.y;
                        distancePoint.weight = tempDistance;
                    }
                    break;
                }
            }

            if (!find) {
                if (stack.isEmpty())
                    break;

                Point nextStart = stack.pop();
                tempDistance -= nextStart.weight;
                start = nextStart.y;
            }
        }

        return distancePoint;
    }
}
