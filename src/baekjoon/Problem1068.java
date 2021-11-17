package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1068 {
    static int leafNodeCount = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        int nodeCount = sc.nextInt();
        for (int i = 0; i < nodeCount; i++) {
            tree.add(new ArrayList<>());
        }
        int rootNode = 0;
        for (int i = 0; i < nodeCount; i++) {
            int parent = sc.nextInt();
            if (parent != -1) {
                tree.get(parent).add(i);
            } else {
                rootNode = i;
            }
        }
        int removedNode = sc.nextInt();
        if (removedNode != rootNode) {
            for(ArrayList<Integer> vertex : tree) {
                if(vertex.contains(removedNode)) {
                    vertex.remove(vertex.indexOf(removedNode));
                }
            }


            dfs(tree, rootNode, removedNode);
        }
        System.out.println(leafNodeCount);
        sc.close();
    }

    public static void dfs(ArrayList<ArrayList<Integer>> tree, int x, int removedNode) {
        if (tree.get(x).size() == 0)
            leafNodeCount++;
        for (int i = 0; i < tree.get(x).size(); i++) {
            dfs(tree, tree.get(x).get(i), removedNode);
        }
    }
}
