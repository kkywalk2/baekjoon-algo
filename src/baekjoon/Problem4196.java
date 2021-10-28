package baekjoon;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Problem4196 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int testNum = 0; testNum < testCase; testNum++) {
            int blockCount = sc.nextInt();
            int relationCount = sc.nextInt();

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            ArrayList<ArrayList<Integer>> rgraph = new ArrayList<>();
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            for (int blockNum = 0; blockNum <= blockCount; blockNum++) {
                graph.add(new ArrayList<>());
                rgraph.add(new ArrayList<>());
                result.add(new ArrayList<>());
            }

            for (int relationNum = 0; relationNum < relationCount; relationNum++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph.get(x).add(y);
                rgraph.get(y).add(x);
            }

            Stack<Integer> resultQueue = new Stack<>();
            boolean[] visited = new boolean[blockCount + 1];
            for (int i = 1; i <= blockCount; i++) {
                if (visited[i] == false)
                    dfs(resultQueue, visited, graph, i);
            }

            int groupNum = 1;
            int[] scc = new int[blockCount + 1];

            while (!resultQueue.isEmpty()) {
                int start = resultQueue.pop();

                if (scc[start] != 0)
                    continue;

                rdfs(scc, groupNum, result, rgraph, start);
                groupNum++;
            }

            int[] indegree = new int[groupNum];
            for(int i = 1; i <= blockCount; i++) {
                ArrayList<Integer> list = graph.get(i);
                for(int point : list) {
                    if(scc[point] != scc[i]) {
                        indegree[scc[point]]++;
                    }
                }
            }

            int zeroCount = 0;
            for (int i = 1; i < groupNum; i++) {
                if (indegree[i] == 0)
                    zeroCount++;
            }

            System.out.println(zeroCount);
        }
        sc.close();
    }

    //재귀 안쓰고 할 방법 없나..
    /*public static void dfs(Queue<Integer> resultQueue, boolean[] visited, ArrayList<ArrayList<Integer>> graph,
            int start) {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.push(start);
        resultQueue.offer(start);
        visited[start] = true;

        while (!tempStack.isEmpty()) {
            int next = tempStack.pop();
            ArrayList<Integer> connectedList = graph.get(next);

            for (int nextConnected : connectedList) {
                if (visited[nextConnected] == false) {
                    tempStack.push(nextConnected);
                    resultQueue.offer(nextConnected);
                    visited[nextConnected] = true;
                    break;
                }
            }
        }
    }*/

    public static void dfs(Stack<Integer> resultQueue, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int start) {
        visited[start] = true;

        for (int now : graph.get(start)) {
            if (!visited[now]) {
                dfs(resultQueue, visited, graph, now);
            }
        }

        resultQueue.push(start);
    }

    public static void rdfs(int[] scc, int groupNum, ArrayList<ArrayList<Integer>> result,
            ArrayList<ArrayList<Integer>> rgraph, int start) {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.push(start);
        scc[start] = groupNum;
        result.get(groupNum).add(start);

        while (!tempStack.isEmpty()) {
            int next = tempStack.pop();
            ArrayList<Integer> connectedList = rgraph.get(next);

            for (int nextConnected : connectedList) {
                if (scc[nextConnected] == 0) {
                    scc[nextConnected] = groupNum;
                    tempStack.push(nextConnected);
                    result.get(groupNum).add(nextConnected);
                    break;
                }
            }
        }
    }
}
