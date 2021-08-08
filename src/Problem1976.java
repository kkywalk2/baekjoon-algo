import java.util.Scanner;

public class Problem1976 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        int[] travel = new int[m];
        int[] parent = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();

                if(map[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        
        for(int i = 0; i < m; i++) {
            travel[i] = sc.nextInt();
        }

        for(int i = 0; i < m - 1; i++) {
            if(!isSameUnion(parent, travel[i] - 1, travel[i + 1] - 1)) {
                System.out.println("NO");
                sc.close();
                return;
            }
        }
        System.out.println("YES");
        sc.close();
    }

    public static int findParent(int[] parent, int x) {
        if(x == parent[x]) {
            return x;
        } else
            return parent[x] = findParent(parent, parent[x]);
    }

    public static boolean isSameUnion(int[] parent, int x,int y) {
        x = findParent(parent, x);
        y = findParent(parent, y);
        if(x != y) return false;
        else return true;
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
