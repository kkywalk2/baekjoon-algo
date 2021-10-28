package baekjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Scanner;

public class Problem2150 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rgraph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            rgraph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            graph.get(A).add(B);
            rgraph.get(B).add(A);
        }

        boolean[] visited = new boolean[V + 1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph, stack);
            }
        }

        Arrays.fill(visited, false);
        int groupNum = 0;

        while (!stack.isEmpty()) {
            int start = stack.pop();

            if (visited[start]) {
                continue;
            }

            redfs(start, groupNum, visited, rgraph, result);
            groupNum++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(groupNum);
        sb.append("\n");

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < groupNum; i++) {
            Collections.sort(result.get(i));
            map.put(result.get(i).get(0), i);
        }

        map.keySet().forEach(key -> {
            int value = map.get(key);

            for (int now : result.get(value)) {
                sb.append(now);
                sb.append(" ");
            }
            sb.append("-1\n");
        });

        System.out.print(sb);
        sc.close();
    }

    public static void dfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack) {
        visited[start] = true;

        for (int now : graph.get(start)) {
            if (!visited[now]) {
                dfs(now, visited, graph, stack);
            }
        }

        stack.push(start);
    }

    public static void redfs(int start, int groupNum, boolean[] visited, ArrayList<ArrayList<Integer>> rgraph, ArrayList<ArrayList<Integer>> result) {
        visited[start] = true;
        result.get(groupNum).add(start);

        for (int now : rgraph.get(start)) {
            if (!visited[now]) {
                redfs(now, groupNum, visited, rgraph, result);
            }
        }
    }
}