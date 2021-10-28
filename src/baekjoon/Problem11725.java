package baekjoon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Problem11725 {
    //static int[][] points;
    static Map<Integer,List<Integer>> points;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        points = new HashMap<>();
        parent = new int[m + 1];

        for (int i = 0; i < m - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(points.get(x) == null){
                points.put(x, new ArrayList<>());
            }
            points.get(x).add(y);
            if(points.get(y) == null){
                points.put(y, new ArrayList<>());
            }
            points.get(y).add(x);

        }
        bfs(1, m);
        for(int i = 2; i <= m; i++){
            System.out.println(parent[i]);
        }
        sc.close();
    }

    public static void bfs(int start, int size) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visits = new boolean[size + 1];
        queue.offer(start);
        visits[start] = true;
        while (!queue.isEmpty()) {
            start = queue.poll();
            for (var v : points.get(start)) {
                if (visits[v] == false) {
                    queue.offer(v);
                    visits[v] = true;
                    parent[v] = start;
                }
            }
        }
    }
}