package baekjoon;
import java.util.Scanner;

public class Problem1717 {
    static public class Caculation {
        public int c;
        public int x;
        public int y;
    }  
    public static void main(String[] args) throws Exception {

        int setCount;
        int caculationCount;
        int[] parent;
        Caculation[] caculation;

        Scanner sc = new Scanner(System.in);
        setCount = sc.nextInt();
        caculationCount = sc.nextInt();
        parent = new int[setCount + 2];
        caculation = new Caculation[caculationCount];

        for(int i = 1; i <= setCount + 1; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < caculationCount; i++) {
            caculation[i] = new Caculation();
            caculation[i].c = sc.nextInt();
            caculation[i].x = sc.nextInt();
            caculation[i].y = sc.nextInt();
        }

        for(int i = 0; i < caculationCount; i++) {
            if(caculation[i].c == 0){
                union(parent, caculation[i].x, caculation[i].y);
            }else{
                if(isSameUnion(parent, caculation[i].x, caculation[i].y))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

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