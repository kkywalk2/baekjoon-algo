package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2252 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(x).add(y);
            indegree[y]++;
        }
        degreeSort(list, indegree);
        sc.close();
    }

    public static void degreeSort(ArrayList<ArrayList<Integer>> list, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x); sb.append(" ");

            for(int y : list.get(x)) {
                indegree[y]--;
                if(indegree[y] == 0) queue.add(y);
            }
        }

        System.out.println(sb);
    }
}
