import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2251 {

    static public class State {
        public int[] x;

        public State(int[] X) {
            this.x = new int[3];
            for (int i = 0; i < 3; i++)
                this.x[i] = X[i];
        }

        State move(int from, int to, int[] limit) {
            int[] nX = new int[] { x[0], x[1], x[2] };
            if (x[from] + x[to] >= limit[to]) {
                nX[from] -= limit[to] - x[to];
                nX[to] = limit[to];
            } else {
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = sc.nextInt();
        }
        boolean[] possible = bfs(0, 0, limit[2], limit);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= limit[2]; i++) {
            if (possible[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb);
        sc.close();
    }

    static boolean[] bfs(int x1, int x2, int x3, int[] limit) {
        Queue<State> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[205][205][205];
        boolean[] possible = new boolean[205];

        visit[x1][x2][x3] = true;
        queue.add(new State(new int[] { x1, x2, x3 }));

        while (!queue.isEmpty()) {
            State st = queue.poll();
            if (st.x[0] == 0)
                possible[st.x[2]] = true;
            for (int from = 0; from < 3; from++)
                for (int to = 0; to < 3; to++) {
                    if (from == to)
                        continue;
                    State nxt = st.move(from, to, limit);

                    if (!visit[nxt.x[0]][nxt.x[1]][nxt.x[2]]) {
                        visit[nxt.x[0]][nxt.x[1]][nxt.x[2]] = true;
                        queue.add(nxt);
                    }
                }
        }

        return possible;
    }
}
