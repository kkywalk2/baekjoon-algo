import java.util.Scanner;

public class Problem3584 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tcCount = sc.nextInt();
        for (int tcNum = 0; tcNum < tcCount; tcNum++) {
            int nodeCount = sc.nextInt();
            int[] parents = new int[nodeCount + 1];
            for (int lineNum = 0; lineNum < nodeCount - 1; lineNum++) {
                int parent = sc.nextInt();
                int me = sc.nextInt();
                parents[me] = parent;
            }
            int a = sc.nextInt();
            int b = sc.nextInt();
            searchAncestor(a, b, parents);
        }
        sc.close();
    }

    public static void searchAncestor(int a, int b, int[] parents) {
        int currentA = a;
        int currentB = b;

        int depthA = getDepth(a, parents);
        int depthB = getDepth(b, parents);

        while(depthA != depthB) {
            if(depthA > depthB) {
                currentA = parents[currentA];
                depthA--;
            }else {
                currentB = parents[currentB];
                depthB--;
            }
        }

        while(currentA != 0 && currentB !=0 && currentA != currentB) {
            currentA = parents[currentA];
            currentB = parents[currentB];

            if(currentA == currentB) 
                break;
        }

        System.out.println(currentA);
    }

    public static int getDepth(int target, int[] parents) {
        int depth = 0;
        int current = target;
        while(current != 0) {
            current = parents[current];
            depth++;
        }
        return depth;
    }
}
