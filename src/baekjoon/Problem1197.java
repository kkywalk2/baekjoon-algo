package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1197 {

    public static class Point implements Comparable<Point> {
        public int x;
        public int y;
        public int weight;

        @Override
        public int compareTo(Point o) {
            if (this.weight < o.weight) {
                return -1;
            } else if (this.weight == o.weight) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int lineCount = sc.nextInt();
        int[] parent = new int[nodeCount + 1];
        Point[] weights = new Point[lineCount];

        for (int i = 0; i < lineCount; i++) {
            weights[i] = new Point();
            weights[i].x = sc.nextInt();
            weights[i].y = sc.nextInt();
            weights[i].weight = sc.nextInt();
        }
        
        for (int i = 1; i <= nodeCount; i++) {
            parent[i] = i;
        }

        Arrays.sort(weights);

        //
        int result = 0;

        for (int i = 0; i < lineCount; i++) {
            if (!isSameUnion(parent, weights[i].x, weights[i].y)) {
                union(parent, weights[i].x, weights[i].y);
                result += weights[i].weight;
            }
        }

        System.out.println(result);
        sc.close();
    }

    public static int findParent(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        } else
            return parent[x] = findParent(parent, parent[x]);
    }

    public static boolean isSameUnion(int[] parent, int x, int y) {
        x = findParent(parent, x);
        y = findParent(parent, y);
        if (x != y)
            return false;
        else
            return true;
    }

    public static void union(int[] parent, int x, int y) {
        x = findParent(parent, x);
        y = findParent(parent, y);
        if(x != y) {
            if(x > y) parent[x] = y;
            else parent[y] = x;
        }
    }
}
